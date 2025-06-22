package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessServiceImpl3MockTest {
    @Mock
    SomeDataService mockDataService;
    @InjectMocks
    SomeBusinessServiceImpl3 impl3;
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
