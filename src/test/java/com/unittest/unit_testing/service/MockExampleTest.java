package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MockExampleTest {

    //basic
    @Test
    void mockList(){
        List list = mock(List.class);
        when(list.size()).thenReturn(5);
        assertEquals(5,list.size());
    }

    //mutiple return values
    @Test
    void mockList2(){
        List list = mock(List.class);
        when(list.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,list.size());
        assertEquals(10,list.size());
    }

    @Test
    void mockList3(){
        List list = mock(List.class);
        when(list.get(0)).thenReturn("John Wick");
        assertEquals("John Wick",list.get(0));
        assertEquals(null,list.get(1));
    }

    @Test
    void mockList4(){
        List list = mock(List.class);
        when(list.get(anyInt())).thenReturn("John Wick");
        assertEquals("John Wick",list.get(0));
        assertEquals("John Wick",list.get(1));
//        assertEquals(null,list.get(1));//this will fail now
    }

    @Test
    void verificationBasics(){
        List<String> list = mock(List.class);
        String value1 = list.get(0);
        String value2 = list.get(1);

        //verify
        verify(list).get(0); // verify that this mock list's get(index) method is called
        verify(list).get(1); // verify that this mock list's get(index) method is called
        verify(list, times(1)).get(1);
        verify(list, times(2)).get(anyInt());
        verify(list, atLeast(1)).get(anyInt());
        verify(list,never()).get(2);
    }

    //Argument Captor
    @Test
    void argumentCapturing(){
        List<String> mock = mock(List.class);
        mock.add("JohnWick");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("JohnWick",captor.getValue());
    }

    //Argument Captor
    @Test
    void argumentCapturingAll(){
        List<String> mock = mock(List.class);
        mock.add("JohnWick");
        mock.add("JohnWick2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("JohnWick",allValues.get(0));
        assertEquals("JohnWick2",allValues.get(1));
    }

//    Below code shows difference between mock vs spy

    @Test
    void mocking(){
        ArrayList<String> mockList = mock(ArrayList.class);

        System.out.println(mockList.get(0));//null
        System.out.println(mockList.size());//0

        mockList.add("One");
        mockList.add("Two");

        System.out.println(mockList.size());// still prints 0 because its mock i.e.fake object
//        let's mock'
        when(mockList.size()).thenReturn(100);
        System.out.println(mockList.size());//100
        mockList.add("Three");
        System.out.println(mockList.size());//100
    }

    //spy >> it acts as a real object until it mocked
    @Test
    void spying(){
        ArrayList<String> spyList = spy(ArrayList.class);

//        System.out.println(spyList.get(0));//it will throw exception since there is no elements in given list i.e it acts as real object
        spyList.add("One");
        System.out.println(spyList.get(0));//One
        System.out.println(spyList.size());//1

        spyList.add("Two");
        System.out.println(spyList.size());//2
//        let's mock'
        when(spyList.size()).thenReturn(100);
        System.out.println(spyList.size());//100
        spyList.add("Three");
        System.out.println(spyList.size());//100
    }
}
