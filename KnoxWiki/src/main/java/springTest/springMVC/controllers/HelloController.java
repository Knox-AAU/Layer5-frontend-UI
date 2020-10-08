package springTest.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springTest.springMVC.controllerSupport.FileManager;
import springTest.springMVC.datatypes.frontendfile;
import springTest.springMVC.security.LoginValidator;

import java.util.ArrayList;
import java.util.List;

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



}

