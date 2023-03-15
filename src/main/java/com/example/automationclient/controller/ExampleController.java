package com.example.automationclient.controller;

import com.example.automationclient.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
@Api(value = "ExampleController", tags = { "ExampleController" })
public class ExampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    @ApiOperation(value = "Get a hello message", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved hello message"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public String hello() {
        LOGGER.info("Received request for hello message");
        return exampleService.getHelloMessage();
    }

    @GetMapping("/goodbye")
    @ApiOperation(value = "Get a goodbye message", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved goodbye message"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public String goodbye() {
        LOGGER.info("Received request for goodbye message");
        return exampleService.getGoodbyeMessage();
    }

    @PutMapping("/put")
    @ApiOperation(value = "Update a message", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated message"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public String update() {
        LOGGER.info("Received request for update message");
        return exampleService.updateMessage();
    }

    @PostMapping("/post")
    @ApiOperation(value = "Post a message", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully posted message"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public String post() {
        LOGGER.info("Received request for post message");
        return exampleService.postMessage();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete a message", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted message"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public String delete() {
        LOGGER.info("Received request for delete message");
        return exampleService.deleteMessage();
    }
}
