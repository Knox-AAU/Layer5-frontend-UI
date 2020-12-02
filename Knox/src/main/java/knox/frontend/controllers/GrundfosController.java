package knox.frontend.controllers;

import knox.frontend.models.Search;
import knox.frontend.utility.FileManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/grundfos")
@Controller
public class GrundfosController extends  AbstractCompanyController {
    public GrundfosController() {
        super();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView GetSearchPage(@RequestParam(name = "searched", defaultValue = "hello there Theis") String searchname){
        Search search = new Search("Grundfos search engine", "Grundfos", "Nordjyske", "/nordjyske");
        ModelAndView modelAndView = new ModelAndView("Grundfos/GrundfosInterface");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("grundfos").finish();
        modelAndView.addObject("search", search);
        modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }

    @RequestMapping(value = "/search")
    public ModelAndView GetArticlePage(@RequestParam(name = "article") int articleId){
        System.out.println("Hello there, Grundfos. Article id: " + articleId);
        ModelAndView modelAndView = new ModelAndView("Grundfos/GrundfosArticle");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("grundfos").finish();
        modelAndView.addObject("article", ddHash.get(articleId));
        modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }
}
