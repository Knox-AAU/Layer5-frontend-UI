package knox.frontend.controllers;
import knox.frontend.models.LoginAttempt;
import knox.frontend.utility.FileManager;
import knox.frontend.utility.Uservalidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Neutral")
@Controller
public class LoginController {

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