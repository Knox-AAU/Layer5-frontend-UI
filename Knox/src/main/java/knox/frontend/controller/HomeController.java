package knox.frontend.controller;
import knox.frontend.model.HeaderData;
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
        modelAndView.addObject("HubIcons", hubicons);
        modelAndView.addObject("Header", HeaderData.CreateKnoxHeader("UserName"));

        // Add files
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("knox").AddCssFile("hub").finish();
        return modelAndView;
    }

    @RequestMapping("/Neutral")
    @Controller
    public static class LoginController {

        @RequestMapping(method = RequestMethod.POST)
        public String GetLoginPage(@RequestParam String username,@RequestParam String password, ModelMap model){
            FileManager fileManager = new FileManager(model);
            fileManager.AddCssFile("login");
            fileManager.finish();

            if (Uservalidator.ValidateLogin(username, password)) {
                model.addAttribute("UserFeedback","Great success!");
                return "Neutral/LoginPage";// Move on to next view I.E the HUB
            }
            else
                model.addAttribute("UserFeedback","Incorrect Login, please try again");
            return "Neutral/LoginPage";
        }

        @RequestMapping(method = RequestMethod.GET) // This is accessed, when the Url is entered
        public String Login(ModelMap model){
            FileManager fileManager = new FileManager(model);
            fileManager.AddCssFile("login");
            fileManager.finish();

            return "Neutral/LoginPage";
        }
    }




}