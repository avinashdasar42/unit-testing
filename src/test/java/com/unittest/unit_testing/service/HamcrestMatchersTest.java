package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> nums = Arrays.asList(12,13,14);

        assertThat(nums, hasSize(3));
        assertThat(nums, hasItem(13));
        assertThat(nums, everyItem(greaterThan(10)));
        assertThat(nums, everyItem(lessThan(100)));

        assertThat("John Doe", containsString("John"));
        assertThat("John Doe", startsWith("John"));
        assertThat("", isEmptyString());
    }
}
