package com.github.saden1.hk2testng;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.Binder;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.IExecutionListener;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 *
 * @author saden
 */
public class HK2TestListenerAdapter implements IExecutionListener, IHookable, IConfigurable {

    private static final Map<String, ServiceLocator> serviceLocators = new ConcurrentHashMap();
    private static final Map<Class, Object> testClasses = new ConcurrentHashMap();
    private static final Map<Class, Binder> binderClasses = new ConcurrentHashMap();

    @Override
    public void onExecutionStart() {
    }

    @Override
    public void onExecutionFinish() {
        for (Map.Entry<String, ServiceLocator> entry : serviceLocators.entrySet()) {
            entry.getValue().shutdown();
        }

        serviceLocators.clear();
        testClasses.clear();
        binderClasses.clear();
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        try {
            injectTestInstance(testResult);
            callBack.runTestMethod(testResult);
        } catch (InstantiationException e) {
            testResult.setThrowable(e);
        } catch (IllegalAccessException e) {
            testResult.setThrowable(e);
        }
    }

    @Override
    public void run(IConfigureCallBack callBack, ITestResult testResult) {
        try {
            injectTestInstance(testResult);
            callBack.runConfigurationMethod(testResult);
        } catch (InstantiationException e) {
            testResult.setThrowable(e);
        } catch (IllegalAccessException e) {
            testResult.setThrowable(e);
        }
    }

    private void injectTestInstance(ITestResult testResult) throws InstantiationException, IllegalAccessException {
        ServiceLocator locator = null;
        Object testInstance = testResult.getMethod().getInstance();

        if (testInstance != null) {
            HK2 hk2 = testInstance.getClass().getAnnotation(HK2.class);

            if (hk2 != null) {
                if (!testClasses.containsKey(testInstance.getClass())) {
                    Class<? extends Binder>[] hk2BinderClasses = hk2.binders();

                    if (hk2.populate()) {
                        locator = ServiceLocatorUtilities.createAndPopulateServiceLocator(hk2.value());
                        serviceLocators.put(locator.getName(), locator);
                    }

                    if (hk2BinderClasses.length > 0) {
                        Binder[] binders = new Binder[hk2BinderClasses.length];
                        int index = 0;
                        for (Class<? extends Binder> binderClass : hk2BinderClasses) {
                            Binder binder = binderClasses.get(binderClass);

                            if (binder == null) {
                                binder = binderClass.newInstance();
                                binderClasses.put(binderClass, binder);
                            }

                            binders[index++] = binder;
                        }

                        if (locator == null) {
                            locator = ServiceLocatorUtilities.bind(hk2.value(), binders);
                            serviceLocators.put(locator.getName(), locator);
                        } else {
                            ServiceLocatorUtilities.bind(locator, binders);
                        }
                    }

                    if (locator != null) {
                        locator.inject(testInstance);
                    }

                    testClasses.put(testInstance.getClass(), testInstance);
                }
            }
        }
    }

}
