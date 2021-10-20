package knox.frontend.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import knox.frontend.utility.GrundfosConnection;
import knox.frontend.utility.GrundfosSearchData;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class RestGrundfos {
  @PostMapping(value = "/grundfossearch", consumes = "application/json")
  @ResponseBody
  public String search(@RequestBody String search) throws JsonProcessingException {
    final ObjectMapper objectMapper = new ObjectMapper();
    GrundfosConnection gc = new GrundfosConnection();
    GrundfosSearchData grundfosSearchData =
        objectMapper.readValue(search, GrundfosSearchData.class);
    String result = gc.Search(grundfosSearchData);
    return result;
  }
}
