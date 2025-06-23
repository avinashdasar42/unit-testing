package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExampleTest {

    @Test
    public void learning(){
        List<Integer> nums = Arrays.asList(12,13,14);

        //chaining is possible here
        assertThat(nums).hasSize(3)
                .contains(12,13,14)
                .allMatch( x->x>10)
                .allMatch(x -> x<100);

        assertThat("John Doe")
                .contains("John")
                .startsWith("John")
                .endsWith("Doe");

    }
}
