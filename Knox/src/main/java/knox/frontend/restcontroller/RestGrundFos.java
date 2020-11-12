package knox.frontend.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import knox.frontend.models.DummyData;
import knox.frontend.models.DummyDataGrundfos;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class RestGrundFos {

    @PostMapping(value = "/grundfossearch", consumes = "application/json")
    @ResponseBody
    public String search(@RequestBody String search) throws JsonProcessingException {
        System.out.println("Working");
        System.out.println(search);

        ObjectMapper objectMapper = new ObjectMapper();
        DummyData dummydata = DummyData.CreateDummy(1);
        String data = objectMapper.writeValueAsString(dummydata);


        return data;
    }
}
