package com.github.saden1.hk2testng;

import com.github.saden1.hk2testng.service.NamedService;
import javax.inject.Inject;
import javax.inject.Named;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2
public class NamedServiceInjectionTest {

    @Named("namedService")
    @Inject
    NamedService namedService;

    @Test
    public void assertNamedServiceInjecton() {
        assertThat(namedService).isNotNull();
    }

    @Test
    public void assertSecondaryService() {
        assertThat(namedService.getSecondaryService()).isNotNull();
    }
}
