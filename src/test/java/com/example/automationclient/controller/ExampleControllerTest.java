package com.example.automationclient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ExampleControllerTest {

    @Mock
    Logger LOGGER;

    @Mock
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @InjectMocks
    ExampleController exampleController;

    @Test
    @Tag(name = "swagger")
    @Operation(summary = "Test Swagger UI Generation")
    @ApiResponses(value = {})
    void testSwaggerUI() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(content, Object.class);
    }

    @Test
    @Tag(name = "unit")
    @Operation(summary = "hello")
    @ApiResponses(value = {})
    void testHello() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/example/hello"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotNull(result.getResponse().getContentAsString());
        Assertions.assertEquals("Hello, World!", result.getResponse().getContentAsString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme