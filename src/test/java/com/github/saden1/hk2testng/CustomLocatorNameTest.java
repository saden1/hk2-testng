package com.github.saden1.hk2testng;

import com.github.saden1.hk2testng.service.PrimaryService;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.glassfish.hk2.api.ServiceLocator;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2(CustomLocatorNameTest.CUSTOM_LOCATOR_NAME)
public class CustomLocatorNameTest {

    public static final String CUSTOM_LOCATOR_NAME = "custom";

    @Inject
    ServiceLocator sericeLocator;

    @Inject
    PrimaryService primaryService;

    @Test
    public void assertPrimaryServiceInjecton() {
        assertThat(primaryService).isNotNull();
    }

    @Test
    public void assertSecondaryService() {
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }

    @Test
    public void assertServiceLocatorIsCustom() {
        assertThat(sericeLocator.getName())
                .isEqualTo(CUSTOM_LOCATOR_NAME);
    }
}
