package knox.frontend.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHallo(ModelMap model){
        model.addAttribute("message","Hallo Spring MVC Framework");
        return "hello";
    }

}
