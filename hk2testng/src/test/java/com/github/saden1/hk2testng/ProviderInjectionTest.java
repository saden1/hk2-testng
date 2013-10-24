package com.github.saden1.hk2testng;

import com.github.saden1.hk2testng.service.PrimaryService;
import javax.inject.Inject;
import javax.inject.Provider;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2
public class ProviderInjectionTest {

    @Inject
    Provider<PrimaryService> primaryServiceProvider;

    @Test
    public void assertPrimaryServiceInjecton() {
        assertThat(primaryServiceProvider).isNotNull();
    }

    @Test
    public void assertSecondaryService() {
        PrimaryService primaryService = primaryServiceProvider.get();
        assertThat(primaryService).isNotNull();
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }
}
