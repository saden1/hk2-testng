package com.github.saden1.hk2testng.binder;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author saden
 */
public class CombinedBinder extends AbstractBinder {

    @Override
    protected void configure() {

        install(new PrimaryBinder(), new SecondaryBinder());
    }

}
