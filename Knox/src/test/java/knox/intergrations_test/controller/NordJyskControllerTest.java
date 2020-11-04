package knox.intergrations_test.controller;

import knox.frontend.controllers.GrundfosController;
import knox.frontend.controllers.NordJyskController;
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
@WebMvcTest(NordJyskController.class)
@Import(NordJyskController.class)
class NordJyskControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void NordJyskePageAccessible() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/nordjyske");
        // Make Request
        mvc.perform(request).andExpect(status().isOk());
    }
}