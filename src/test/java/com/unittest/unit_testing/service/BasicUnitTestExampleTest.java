package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicUnitTestExampleTest {

    @Test
    void calculateSum_basic(){
        BasicUnitTestExample ex = new BasicUnitTestExample();
        int actual = ex.calculateSum(new int[]{1,2,3});
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSum_whenEmpty(){
        BasicUnitTestExample ex = new BasicUnitTestExample();
        int actual = ex.calculateSum(new int[]{});
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSum_whenSingleValue(){
        BasicUnitTestExample ex = new BasicUnitTestExample();
        int actual = ex.calculateSum(new int[]{13});
        int expected = 13;
        assertEquals(expected, actual);
    }
}