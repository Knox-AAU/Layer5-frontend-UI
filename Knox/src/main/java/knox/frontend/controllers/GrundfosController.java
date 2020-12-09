package knox.frontend.controllers;

import knox.frontend.models.HeaderData;
import knox.frontend.models.Search;
import knox.frontend.utility.FileManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@RequestMapping(value = "/grundfos")
@Controller
public class GrundfosController extends  AbstractCompanyController {
    //ModelAndView modelAndView = new ModelAndView();
    //FileManager fileManager = new FileManager(modelAndView.getModelMap());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView GetSearchPage(@RequestParam(name = "searched", defaultValue = "hello there Theis") String searchname){

        System.out.println("Grundfos");
        Search search = new Search("Grundfos search engine", "Grundfos", "Nordjyske", "/nordjyske");
        ModelAndView modelAndView = new ModelAndView("Grundfos/GrundfosInterface");
        modelAndView.setViewName("Grundfos/GrundfosInterface");
        Initiate(modelAndView);
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("search-interface").finish();
        modelAndView.addObject("search", search);
        modelAndView.addObject("ddHash", ddHash);
        modelAndView.addObject("Header", HeaderData.CreateGrundfosHeader("UserName"));
        return modelAndView;
    }

    @RequestMapping(value = "/search")
    public ModelAndView GetArticlePage(@RequestParam(name = "article") int articleId){
        System.out.println("Hello there, Grundfos. Article id: " + articleId);
        ModelAndView modelAndView = new ModelAndView("Grundfos/GrundfosArticle");

        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("article").finish();

        modelAndView.addObject("article", ddHash.get(articleId));
        modelAndView.addObject("ddHash", ddHash);
        modelAndView.addObject("Header", HeaderData.CreateGrundfosHeader("UserName"));
        return modelAndView;
    }

    @Override
    void Initiate(ModelAndView modelAndView ) {

    }
}
