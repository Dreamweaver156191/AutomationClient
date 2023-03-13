package com.example.automationclient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@Api(value = "ExampleController", tags = { "ExampleController" })
public class ExampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);

    @GetMapping("/hello")
    @ApiOperation(value = "Get a hello message", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved hello message"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public String hello() {
        LOGGER.info("Received request for hello message");
        return "Hello, World!";
    }
}
