package com.example.automationclient.controller;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/example")
@Api(value = "ExampleController", tags = { "ExampleController" })
public class ExampleController {

    @GetMapping("/hello")
    @ApiOperation(value = "Get a hello message", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved hello message"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public String hello() {
        return "Hello, World!";
    }
}
