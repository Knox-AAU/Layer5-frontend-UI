package springTest.springMVC.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import springTest.springMVC.controllerSupport.XMLGenerator;
import springTest.springMVC.datatypes.JavaClassStruct;


@RestController
public class RestAPI {

  public RestAPI() {}

  @PostMapping(value = "/test", consumes = "application/json")
  @ResponseBody
  public String testajax(@RequestBody String name) throws JsonProcessingException {

    System.out.println("testajax");

    ObjectMapper objectMapper = new ObjectMapper();

    try {
      JavaClassStruct jcs = objectMapper.readValue(name, JavaClassStruct.class);

      // Generate XML-file. Generation happens in constructor, so no need for calling further
      // methods
      XMLGenerator xml = new XMLGenerator(jcs);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return "success";
  }
}
