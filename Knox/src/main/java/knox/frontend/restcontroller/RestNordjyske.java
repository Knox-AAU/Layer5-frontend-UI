package knox.frontend.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import knox.frontend.model.DummyData;
import knox.frontend.model.NordjyskeResult;
import knox.frontend.utility.NordJyskeConnection;
import knox.frontend.utility.NordJyskeSearchData;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
public class RestNordjyske {


    @PostMapping(value = "/nordjysksearch", consumes = "application/json")
    @ResponseBody
    public String search(@RequestBody String search) throws JsonProcessingException {
        System.out.println("Working");
        System.out.println(search);

        //DummyData dummydata = DummyData.CreateDummy(1);
        //String data = objectMapper.writeValueAsString(dummydata);

        final ObjectMapper objectMapper = new ObjectMapper();
        NordJyskeConnection nc = new NordJyskeConnection();
        NordJyskeSearchData nordJyskeSearchData = objectMapper.readValue(search, NordJyskeSearchData.class);
        String result = nc.Search(nordJyskeSearchData);
        System.out.println("Result: " + result);

        return result;
    }
}