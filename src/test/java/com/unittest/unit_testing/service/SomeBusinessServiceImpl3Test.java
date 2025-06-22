package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessServiceImpl3Test {

    SomeDataService mockDataService = mock(SomeDataService.class);
    SomeBusinessServiceImpl3 impl3 = new SomeBusinessServiceImpl3(mockDataService);

    @Test
    void calculateSumUsingMockDataService_basic(){
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{1,2,3});
        int actual = impl3.calculateSumUsingMockDataService();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumUsingMockDataService_whenEmpty(){
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{});
        int actual = impl3.calculateSumUsingMockDataService();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateSumUsingMockDataService_whenSingleValue(){
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{10});
        int actual = impl3.calculateSumUsingMockDataService();
        int expected = 10;
        assertEquals(expected, actual);
    }
}