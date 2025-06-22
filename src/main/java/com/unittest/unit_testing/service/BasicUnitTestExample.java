package com.unittest.unit_testing.service;

public class BasicUnitTestExample {

    public int calculateSum(int[] arr){
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        return sum;
    }
}
