package com.example.automationclient.swagger;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema()))
public @interface ApiRequestBody {

    // override fields in @Content
    String mediaType() default MediaType.APPLICATION_JSON_VALUE;

    // override fields in @Schema
    String description() default "Request object";

    Class<?> implementation() default Void.class;

}
