package knox.intergrations_test.controller;

import knox.frontend.controllers.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
@Import(HelloController.class)
class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void HomePageAccessible() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/");
        // Make Request
        mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    void TestPageAccessible() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/test");
        // Make Request
        mvc.perform(request).andExpect(status().isOk());
    }
}