package com.github.saden1.hk2testng;

import com.github.saden1.hk2testng.service.PrimaryService;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author saden
 */
public abstract class AbstractInheritedInjectionTest {

    @Inject
    PrimaryService primaryService;

    @BeforeClass
    public void BeforeClass() {
        assertThat(primaryService).isNotNull();
    }
}
