package com.company.SummativeApi.Controller;

import com.company.SummativeApi.model.Words;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;
import com.company.SummativeApi.model.Words;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;



@RunWith(SpringRunner.class)
@WebMvcTest(SummativeWordsController.class)
public class SummativeWordsControllerTest {

    //wiring in the Mockmvc object
    @Autowired
    private MockMvc mockMvc;

    //objectMapper used to convert java objects to Json and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of Words for testing purposes
    private List<Words> wordsList;

    @Before
    public void setUp(){

    }

    //Testing http method GET uri/records
    @Test
    public void shouldReturnAllWordsInCollection() throws Exception {

        //Arrange
        //Convert Java object to Json
        String outputJson = mapper.writeValueAsString(wordsList);

        //Act
        mockMvc.perform(get( "/word"))
                .andDo(print())
                .andExpect(status().isOk());
    }



}
