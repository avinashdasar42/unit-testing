package com.unittest.unit_testing.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

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
}
