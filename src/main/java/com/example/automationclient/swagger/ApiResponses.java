package com.example.automationclient.swagger;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ResponseStatus.class)))
@ApiResponse(responseCode = "200", ref = "OK")
@ApiResponse(responseCode = "201", ref = "CREATED")
@ApiResponse(responseCode = "400", ref = "BAD_REQUEST")
@ApiResponse(responseCode = "404", ref = "NOT_FOUND")
@ApiResponse(responseCode = "500", ref = "INTERNAL_SERVER_ERROR")
public @interface ApiResponses {

}
