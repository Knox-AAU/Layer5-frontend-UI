package knox.frontend.controllers;
import knox.frontend.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatabaseSelectionController {

    @RequestMapping(value = "/grundfos")
    public ModelAndView grundfoss(){
        Search search = new Search("Grundfos search engine", "Grundfos", "Nordjyske", "/nordjyske");
        ModelAndView modelAndView = new ModelAndView("search-interface");
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @RequestMapping(value = "/nordjyske")
    public ModelAndView nordjyske(){
        Search search = new Search("Nordjyske search engine", "Nordjyske", "Grundfos", "/grundfos");
        ModelAndView modelAndView = new ModelAndView("Nordjyske/NordjyskeInterface");
        modelAndView.addObject("search", search);
        return modelAndView;
    }
}
