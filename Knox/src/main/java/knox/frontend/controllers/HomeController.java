package knox.frontend.controllers;
import knox.frontend.models.HeaderData;
import knox.frontend.models.HubIcon;
import knox.frontend.utility.FileManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("/hub")
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


}