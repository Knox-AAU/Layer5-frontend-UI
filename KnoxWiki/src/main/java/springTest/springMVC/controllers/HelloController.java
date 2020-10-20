package springTest.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import springTest.springMVC.controllerSupport.FileManager;
import springTest.springMVC.controllerSupport.XMLLoader;
import springTest.springMVC.datatypes.JavaClassStruct;
import springTest.springMVC.datatypes.frontendfile;
import springTest.springMVC.debug.ClassGenerator;
import springTest.springMVC.security.LoginValidator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("")
@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHallo(ModelMap model){
        System.out.println("printHallo");

        List<frontendfile> list = new ArrayList<frontendfile>();
        list.add(new frontendfile("var", "login_page", frontendfile.FILETYPE.CSS));
        model.addAttribute("CSSFiles",list);
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String Login(@RequestParam String username,@RequestParam String password, ModelMap model) {
        System.out.println("Login");

        if (LoginValidator.ValidatLogin(username,password)){
            model.addAttribute("message","Hallso some Spring MVC Framework");
            return "main";
        } else {
            return "login";
        }

    }
    @RequestMapping(value = "/newclass", method = RequestMethod.GET)
    public String createNewClass(ModelMap model){
        System.out.println("createNewClass");


        new FileManager(model).AddCssFile("addclassform").finish();

        return "addclassform";
    }


    @RequestMapping(value = "/documentation", method = RequestMethod.GET)
    public ModelAndView ShowClass(@RequestParam("class") String className) throws IOException, SAXException, ParserConfigurationException {
        System.out.println("Show a Class");
        JavaClassStruct aclass = ClassGenerator.CreateJavaClassStruct();
        System.out.println(aclass.getName());

        XMLLoader xmlLoader = new XMLLoader();

        //Input className i LoadXML?
        HashMap<String, JavaClassStruct> jcsList = xmlLoader.LoadXML();

        ModelAndView modelAndView = new ModelAndView("classview");
        modelAndView.addObject("jcsList", jcsList);
        modelAndView.addObject("theClass", jcsList.get(className)); // <---- JavaClassStruct-element bliver hardcoded lige pt.
        modelAndView.addObject("test","test");

        new FileManager(modelAndView.getModelMap()).AddCssFile("classview").finish();

        return modelAndView;
    }

/*
    @RequestMapping(value = "/documentation", method = RequestMethod.GET)
    public ModelAndView ShowDocumentation() throws SAXException, IOException, ParserConfigurationException {
        System.out.println("Show doc");


        XMLLoader xmlLoader = new XMLLoader();
        HashMap<String, JavaClassStruct> jcsList = xmlLoader.LoadXML();

        ModelAndView modelAndView = new ModelAndView("documentation");
        modelAndView.addObject("jcsList", jcsList);

        // modelAndView.addObject("test","test");

        return modelAndView;
    }
*/



}

