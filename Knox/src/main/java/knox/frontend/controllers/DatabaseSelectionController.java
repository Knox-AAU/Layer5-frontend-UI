package knox.frontend.controllers;
import knox.frontend.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatabaseSelectionController {

    @RequestMapping(value = "/grundfoss")
    public ModelAndView grundfoss(){
        Search grundfoss = new Search("Grundfoss search engine", "Grundfoss", "Nordjyske", "/nordjyske");
        ModelAndView modelAndView = new ModelAndView("search-interface");
        modelAndView.addObject("search", grundfoss);
        return modelAndView;
    }

    @RequestMapping(value = "/nordjyske")
    public ModelAndView nordjyske(){
        Search nordjyske = new Search("Nordjyske search engine", "Nordjyske", "Grundfoss", "/grundfoss");
        ModelAndView modelAndView = new ModelAndView("search-interface");
        modelAndView.addObject("search", nordjyske);
        return modelAndView;
    }
}
