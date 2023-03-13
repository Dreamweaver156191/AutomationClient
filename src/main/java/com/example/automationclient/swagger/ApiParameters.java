package com.example.automationclient.swagger;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Parameter(name = "uid", description = "The path variable should be an existing uid.", example = "123456", in = ParameterIn.PATH)
@Parameter(name = "ecosystemUid", description = "An existing ecosystem uid.", example = "PorscheKorea", in = ParameterIn.HEADER)
public @interface ApiParameters {
}
