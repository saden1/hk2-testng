package com.github.saden1.hk2testng;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

@HK2
public class InheritedInjectionTest extends AbstractInheritedInjectionTest {

    @Test
    public void assertInheritedInjection() {
        assertThat(primaryService).isNotNull();
    }
}
