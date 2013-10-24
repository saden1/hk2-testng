package com.github.saden1.hk2testng.service.provider;

import com.github.saden1.hk2testng.service.ProvidedService;
import com.github.saden1.hk2testng.service.SecondaryService;
import javax.inject.Inject;
import javax.inject.Provider;
import org.glassfish.hk2.api.Factory;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author saden
 */
@Service
public class ProvidedServiceProvider implements Factory<ProvidedService> {

    private final Provider<SecondaryService> secondaryServiceProvider;

    @Inject
    ProvidedServiceProvider(Provider<SecondaryService> secondaryServiceProvider) {
        this.secondaryServiceProvider = secondaryServiceProvider;
    }

    @Override
    public ProvidedService provide() {
        return new ProvidedServiceImpl(secondaryServiceProvider.get());
    }

    @Override
    public void dispose(ProvidedService providedService) {
        providedService = null;
    }
}
