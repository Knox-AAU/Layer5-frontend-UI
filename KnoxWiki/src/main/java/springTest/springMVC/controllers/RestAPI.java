package springTest.springMVC.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import springTest.springMVC.controllerSupport.XMLGenerator;
import springTest.springMVC.datatypes.JavaClassStruct;
import springTest.springMVC.datatypes.TestAutoCreate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
public class RestAPI {
    //String xmlPath = "C:\\Users\\teisv\\Documents\\Git\\Knox-frontend\\xmltestfile.xml";
    //--------------------------------------------------------------------------------------

    //Path is relative to project, but might have to be changed to a more specific subpath
    String xmlPath = "..\\..\\..\\layer5-frontend-ui\\xmltestfile.xml";


    @PostMapping(value = "/test", consumes = "application/json")
    @ResponseBody
    public String testajax(@RequestBody String name) throws JsonProcessingException {
        System.out.println("testajax");
        //System.out.println(test.getName());

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JavaClassStruct jcs = objectMapper.readValue(name, JavaClassStruct.class);

            //Generate XML-file. Generation happens in constructor, so no need for calling further methods
            XMLGenerator xml = new XMLGenerator(jcs, xmlPath);
        } catch(JsonProcessingException e){
            e.printStackTrace();
        }

        return "success";
    }
}
