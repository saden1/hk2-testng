package com.github.saden1.hk2testng;

import com.github.saden1.hk2testng.service.PrimaryService;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
@HK2
public class ConfigurationMethodInjectionTest {

    @Inject
    PrimaryService primaryService;

    @BeforeSuite
    public void assertBeforeSuiteInjection() {
        assertThat(primaryService).isNotNull();
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }

    @BeforeTest
    public void assertBeforeTestInjection() {
        assertThat(primaryService).isNotNull();
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }

    @BeforeGroups("test")
    public void assertBeforeGroupInjection() {
        assertThat(primaryService).isNotNull();
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }

    @BeforeMethod
    public void assertBeforeMethodInjection() {
        assertThat(primaryService).isNotNull();
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }

    @Test(groups = "test")
    public void assertTestInjection() {
        assertThat(primaryService).isNotNull();
        assertThat(primaryService.getSecondaryService()).isNotNull();
    }

}
