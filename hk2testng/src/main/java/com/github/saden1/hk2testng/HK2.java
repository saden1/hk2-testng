package com.github.saden1.hk2testng;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.glassfish.hk2.utilities.Binder;

/**
 * This annotation specifies what HK2 service locator and binders should be used
 * to instantiate and inject the test class it is annotated with.
 *
 * @author saden
 */
@Documented
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface HK2 {

    /**
     * The name of the service locator that will be used.
     *
     * @return the name of the service locator
     */
    String value() default "hk2-testng-locator";

    /**
     * Create a service locator and populate it with services defined in
     * "META-INF/hk2-locator/default" inhabitant files found in the classpath.
     *
     * @return true if the classpath should be scanned for inhabitant files.
     */
    boolean populate() default true;

    /**
     * A list of binders that should be loaded.
     *
     * @return a list of binders classes
     */
    Class<? extends Binder>[] binders() default {};

}
