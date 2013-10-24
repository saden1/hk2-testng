package com.github.saden1.hk2testng;

import com.github.saden1.hk2testng.service.ProvidedService;
import com.github.saden1.hk2testng.service.provider.ProvidedServiceProvider;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2
public class ProvidedInjectionTest {

    @Inject
    ProvidedService providedService;

    @Inject
    ProvidedServiceProvider providedServiceProvider;

    @Test
    public void assertProvidedServiceInjection() {
        assertThat(providedService)
                .isNotNull();
    }

    @Test
    public void assertSecondaryService() {
        assertThat(providedService.getSecondaryService())
                .isNotNull();
    }

    @Test
    public void asserProviderServiceProviderInject() {
        assertThat(providedServiceProvider)
                .isNotNull();
    }
}
