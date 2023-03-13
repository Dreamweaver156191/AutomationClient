# AutomationClient
Main Commit
TestMe plugin Configuration for Junit5 Auto Generation added.
Testme plugin Configuration for MockMvc Auto test Weblayer added.
TestMe pluin  Configuration for SwaggerUI OAS3 endpoint testing and assertions added.

Use the following base template:

Hardcoded template to test initial Controller class as is:
#parse("TestMe macros.java")
#set($hasMocks=$MockitoMockBuilder.hasMockable($TESTED_CLASS.fields))
#if($PACKAGE_NAME)
package ${PACKAGE_NAME};
#end

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
#if($hasMocks)
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
#end
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
#if($hasMocks)
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
#end

@SpringBootTest
#if($hasMocks)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
#end
public class ${CLASS_NAME} {

#renderMockedFields($TESTED_CLASS.fields)

#if($hasMocks)
    @Mock
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
#end

#renderTestSubjectInit($TESTED_CLASS,$TestSubjectUtils.hasTestableInstanceMethod($TESTED_CLASS.methods),$hasMocks)

    @Test
    @Tag(name = "swagger")
    @Operation(summary = "Test Swagger UI Generation")
    @ApiResponses(value = {})
    void testSwaggerUI() throws Exception {
#if($hasMocks)
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(content, Object.class);
#end
    }

    @Test
    @Tag(name = "unit")
    @Operation(summary = "hello")
    @ApiResponses(value = {})
    void testHello() throws Exception {
#if($hasMocks)
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/example/hello"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotNull(result.getResponse().getContentAsString());
        Assertions.assertEquals("Hello, World!", result.getResponse().getContentAsString());
#end
    }
}

#parse("TestMe Footer.java")
