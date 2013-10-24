package com.github.saden1.hk2testng;

import com.github.saden1.hk2testng.binder.CombinedBinder;
import com.github.saden1.hk2testng.service.PrimaryService;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2(populate = false, binders = {CombinedBinder.class})
public class CombinedBinderInjectionTest {

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
}
