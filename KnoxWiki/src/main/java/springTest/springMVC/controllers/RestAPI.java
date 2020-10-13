package springTest.springMVC.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springTest.springMVC.datatypes.JavaClassStruct;
import springTest.springMVC.datatypes.TestAutoCreate;

import java.util.Map;

@RestController
public class RestAPI {
    @PostMapping(value = "/test", consumes = "application/json")
    @ResponseBody
    public String testajax(@RequestBody String name){
        System.out.println("testajax");
        System.out.println("hey man whattafak " + name);
        //System.out.println(test.getName());

        /*
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, JavaClassStruct> map = objectMapper.readValue(name, new TypeReference<Map<String, Object>>(){});
        */
        return "success";
    }
}
