package com.company.SummativeApi.Controller;

import com.company.SummativeApi.model.Summative;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@WebMvcTest(SummativeController.class)
public class SummativeControllerTest {

    //wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    //A list of records for testing purposes
    private List<Summative> summativeList;

    @Before
    public void setUp() {

    }

    //Testing httpMethod GET uri/quote
    @Test
    public void shouldReturnAllQuotesInCollection() throws Exception {
        //Arrange
        //Convert Java object to JSON

        String outputJson = mapper.writeValueAsString(summativeList);

        //Act
        mockMvc.perform(get("/quote"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //Testing PUT /records/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {

        //Arrange
        Summative inputSummative = new Summative();
        inputSummative.setAuthor("Joseph Campbell");
        inputSummative.setQuote("All the gods, all the heavens, all the hells, are within you");
        inputSummative.setId(2);

        String inputJson = mapper.writeValueAsString(inputSummative);

        mockMvc.perform(
                put("/quote/2")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

}



