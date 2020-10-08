package springTest.springMVC.controllers;


import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springTest.springMVC.datatypes.JavaClassStruct;
import springTest.springMVC.datatypes.TestAutoCreate;

@RestController
public class RestAPI {

    @PostMapping(value = "/test", consumes = "application/json")
    @ResponseBody
    public TestAutoCreate testajax(@RequestBody TestAutoCreate  test){
        System.out.println("testajax");
        System.out.println(test.getName());


        return test;
    }

}
