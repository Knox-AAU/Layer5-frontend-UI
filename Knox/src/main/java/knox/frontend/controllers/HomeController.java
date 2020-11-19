package knox.frontend.controllers;
import knox.frontend.utility.FileManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/")
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
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

}