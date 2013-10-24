package com.github.saden1.hk2testng.binder;

import com.github.saden1.hk2testng.service.PrimaryService;
import com.github.saden1.hk2testng.service.impl.PrimaryServiceImpl;
import javax.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author saden
 */
public class PrimaryBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(PrimaryServiceImpl.class)
                .to(PrimaryService.class)
                .in(Singleton.class);
    }

}
