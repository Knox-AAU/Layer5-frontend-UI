package knox.frontend.controller;
import knox.frontend.model.UserData;
import knox.frontend.model.HubIcon;
import knox.frontend.utility.FileManager;
import knox.frontend.utility.Uservalidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import knox.frontend.model.LoginAttempt;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/")
@Controller
public class HomeController {

    public String GetIndexPage(ModelMap model){

        model.addAttribute("message","KNOX");
        return "index";
    }

    @RequestMapping("/test")
    public String GetTestingPage(ModelMap model){
        model.addAttribute("message","Hallo Spring MVC Framework");
        FileManager fileManager = new FileManager(model);
        fileManager.AddCssFile("test");
        fileManager.AddCssFile("grundfos");
        fileManager.AddJSFile("Dropdown");
        fileManager.finish();

        return "test/jquery_test_view" ;
    }

    @RequestMapping({"/hub",""})
    public ModelAndView GetHubPage (){
        ModelAndView modelAndView = new ModelAndView("Hub");
        // Add to model
        List<HubIcon> hubicons = new ArrayList<>();
        hubicons.add(HubIcon.CreateGrundfosIcon());
        hubicons.add(HubIcon.CreateNordJyskeIcon());

        // Add files
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("knox").AddCssFile("hub").finish();
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET) // This is accessed, when the Url is entered
    public String Login(ModelMap model){
        FileManager fileManager = new FileManager(model);
        fileManager.AddCssFile("knox").AddCssFile("login");
        fileManager.finish();

        return "Neutral/LoginPage";
    }
}