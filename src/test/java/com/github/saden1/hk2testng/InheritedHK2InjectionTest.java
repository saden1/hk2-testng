package com.github.saden1.hk2testng;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class InheritedHK2InjectionTest extends AbstractInheritedHK2InjectionTest {

    @Test
    public void assertInheritedInjection() {
        assertThat(primaryService).isNotNull();
    }
}
