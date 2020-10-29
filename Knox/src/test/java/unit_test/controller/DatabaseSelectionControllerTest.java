package unit_test.controller;

import knox.frontend.controllers.DatabaseSelectionController;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DatabaseSelectionController.class)
@Import(DatabaseSelectionController.class)
class DatabaseSelectionControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void GrundfosPageAccessible() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/grundfos");
        // Make Request
        mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    void NordjyskePageAccessible() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/nordjyske");
        // Make Request
        mvc.perform(request).andExpect(status().isOk());
    }
}