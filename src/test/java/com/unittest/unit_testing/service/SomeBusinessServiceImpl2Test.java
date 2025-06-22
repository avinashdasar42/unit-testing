package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessServiceImpl2Test {

    @Test
    void calculateSumUsingDataService_basic(){
        SomeDataService sds = new SomeDataServiceStub();
        SomeBusinessServiceImpl2 impl2 = new SomeBusinessServiceImpl2(sds);
        int actual = impl2.calculateSumUsingDataService();
        int expected = 6;
        assertEquals(expected,actual);
    }

    @Test
    void calculateSumUsingDataService_whenEmpty(){
        SomeDataService sds = new SomeDataServiceEmptyStub();
        SomeBusinessServiceImpl2 impl2 = new SomeBusinessServiceImpl2(sds);
        int actual = impl2.calculateSumUsingDataService();
        int expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void calculateSumUsingDataService_whenSingleValue(){
        SomeDataService sds = new SomeDataServiceSingleStub();
        SomeBusinessServiceImpl2 impl2 = new SomeBusinessServiceImpl2(sds);
        int actual = impl2.calculateSumUsingDataService();
        int expected = 3;
        assertEquals(expected,actual);
    }

}

class SomeDataServiceStub implements  SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeDataServiceEmptyStub implements  SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceSingleStub implements  SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{3};
    }
}