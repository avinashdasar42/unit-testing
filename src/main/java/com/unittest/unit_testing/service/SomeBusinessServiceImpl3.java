package com.unittest.unit_testing.service;

//this is another example of unit testing using mock
public class SomeBusinessServiceImpl3 {

    private SomeDataService someDataService;

    public SomeBusinessServiceImpl3(SomeDataService someDataService){
        this.someDataService = someDataService;
    }

    public SomeDataService getSomeDataService() {
        return someDataService;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSumUsingMockDataService(){
        int[] arr = someDataService.retrieveAllData();
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        return sum;
    }
}
