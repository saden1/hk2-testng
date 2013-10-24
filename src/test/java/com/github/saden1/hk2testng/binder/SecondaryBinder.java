package com.github.saden1.hk2testng.binder;

import com.github.saden1.hk2testng.service.SecondaryService;
import com.github.saden1.hk2testng.service.impl.SecondaryServiceImpl;
import javax.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author saden
 */
public class SecondaryBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(SecondaryServiceImpl.class)
                .to(SecondaryService.class)
                .in(Singleton.class);
    }

}
