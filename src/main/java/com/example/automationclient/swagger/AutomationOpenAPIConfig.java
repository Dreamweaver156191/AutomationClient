//package com.example.automationclient.swagger;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.examples.Example;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.media.Content;
//import io.swagger.v3.oas.models.media.Schema;
//import io.swagger.v3.oas.models.responses.ApiResponse;
//import io.swagger.v3.oas.models.tags.Tag;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import tech.rippl.porsche.utility.lib.dto.ResponseStatus;
//import tech.rippl.porsche.utility.lib.execption.InternalServerErrorException;
//import tech.rippl.porsche.utility.lib.handler.ApiResponseHandler;
//
//import java.util.Collections;
//import java.util.Optional;
//import java.util.stream.Stream;
//
//@OpenAPIDefinition
//@Configuration
//@Slf4j
//public class AutomationOpenAPIConfig {
//
//    @Value("${spring.application.name}")
//    private String appName;
//
//    @Value("${application.version}")
//    private String version;
//
//    @Value("${application.description}")
//    private String description;
//    @Primary
//    @Bean
//    public OpenAPI logbookOpenAPI() {
//        return new OpenAPI().components(buildSwaggerComponents())
//                .info(new Info().title(appName)
//                        .version(version)
//                        .description(description))
//                .tags(Collections.singletonList(new Tag().name(appName)
//                        .description(description)));
//    }
//
//    private Components buildSwaggerComponents() {
//        Components components = new Components();
//        Stream.of(ApiResponseHandler.values())
//                .forEach(httpStatus -> components.addResponses(httpStatus.name(), buildSwaggerApiResponses(httpStatus)));
//        return components;
//    }
//
//    private ApiResponse buildSwaggerApiResponses(ApiResponseHandler apiResponseHandler) {
//        try {
//            ResponseStatus response = apiResponseHandler.buildResponse();
//            String exampleJsonResponse = new ObjectMapper().writeValueAsString(response);
//
//            Optional<HttpStatus> httpStatusResolve = Optional.ofNullable(HttpStatus.resolve(response.getHttpCode()));
//            String apiResponseDesc = httpStatusResolve.isPresent() ? httpStatusResolve.get()
//                    .getReasonPhrase() : "";
//            return new ApiResponse().content(new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE, new io.swagger.v3.oas.models.media.MediaType().addExamples("default", new Example().summary("default")
//                                    .value(exampleJsonResponse))
//                            .schema(new Schema<ResponseStatus>().example(response)
//                                    .$ref("ResponseStatus"))))
//                    .description(apiResponseDesc);
//
//        } catch (JsonProcessingException ex) {
//            log.error("@@ JsonProcessingException => {}", ex.getMessage());
//            throw new InternalServerErrorException(ex.getMessage());
//        }
//    }
//}
