package knox.intergrations_test.restAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import knox.frontend.model.DummyData;
import knox.frontend.restcontroller.RestGrundfos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestGrundfos.class)
@Import(RestGrundfos.class)
class RestGrundfosTest {
  @Autowired private MockMvc mvc;

  @Test
  void search() throws Exception {
    String url = CreateUrl("grundfossearch");
    String search = "{search: \"test\"}";
    String assertedAuther = "Ole Fink Mejlgaard";

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(url);
    // Make Request
    MvcResult result =
        mvc.perform(request.contentType(MediaType.APPLICATION_JSON).content(search)).andReturn();
    String returnvalue = result.getResponse().getContentAsString();
    // Convert response to artical data type
    ObjectMapper mapper = new ObjectMapper();

    DummyData data = mapper.readValue(returnvalue, DummyData.class);
    assertEquals(assertedAuther, data.getAuthor());
  }

  private String CreateUrl(String method) {
    return "/api/" + method;
  }
}
