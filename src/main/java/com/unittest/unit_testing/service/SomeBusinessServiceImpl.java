package com.unittest.unit_testing.service;

//This is basic example of unit testing
public class SomeBusinessServiceImpl {

    public int calculateSum(int[] arr){
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        return sum;
    }
}
