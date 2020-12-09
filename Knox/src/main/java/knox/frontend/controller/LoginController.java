package knox.frontend.controller;
import knox.frontend.utility.FileManager;
import knox.frontend.utility.Uservalidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    public String Login(ModelMap model){
        FileManager fileManager = new FileManager(model);
        fileManager.AddCssFile("login");
        fileManager.finish();

        return "Neutral/LoginPage";
    }
}
