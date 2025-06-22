package com.unittest.unit_testing.service;

public interface SomeDataService {
    int[] retrieveAllData();
    // int[] retriveDataByName(); if we add new method then all implementors need to implement this new method as well
    // Hence., stubs is not recommended generally it has so many challenges
    // Instead we can use mock
}