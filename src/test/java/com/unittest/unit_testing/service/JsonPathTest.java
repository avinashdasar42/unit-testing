package com.unittest.unit_testing.service;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPathTest {

    @Test
    public void learning(){
        String responseFromService =
                "[{\"id\":1,\"name\":\"John Doe\",\"email\":\"john.doe@gmail.com\"},{\"id\":2,\"name\":\"Jenny Doe\",\"email\":\"jenny.doe@gmail.com\"},{\"id\":3,\"name\":\"James Bond\",\"email\":\"jamesbond007@gmail.com\"}]";

        DocumentContext docContext = JsonPath.parse(responseFromService);
        int length = docContext.read("$.length()");
//        assertEquals(length,3);
        assertThat(length).isEqualTo(3);

        List<Integer> ids = docContext.read("$..id");
        assertThat(ids).hasSize(3).contains(1,2,3);
        String name = docContext.read("$.[1].name");
        assertThat(name).isEqualTo("Jenny Doe");
        System.out.println(docContext.read("$.[0:1]").toString());
    }

}
