package knox.frontend.controllers;

import knox.frontend.models.Search;
import knox.frontend.utility.FileManager;
import knox.frontend.utility.NordJyskeConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/nordjyske")
@Controller
public class NordJyskController extends AbstractCompanyController {
    public NordJyskController() {
        super();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView GetSearchPage(@RequestParam(name = "searched", defaultValue = "hello there Theis") String searchname){

        System.out.println(searchname);
        Search search = new Search("Nordjyske search engine", "Nordjyske", "Grundfos", "/grundfos");
        ModelAndView modelAndView = new ModelAndView("Nordjyske/NordjyskeInterface");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("nordjyske").finish();
        modelAndView.addObject("search", search);
        modelAndView.addObject("ddHash", ddHash);

        NordJyskeConnection nc = new NordJyskeConnection();
        String result = nc.Search("donald trump", "president", "USA");
        System.out.println("Result: " + result);
        return modelAndView;
    }


    @RequestMapping(value = "/search")
    public ModelAndView GetArticlePage(@RequestParam(name = "article") int articleId){
        System.out.println("Hello there, Nordjyske. Article id: " + articleId);
        ModelAndView modelAndView = new ModelAndView("Nordjyske/NordjyskeArticle");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("nordjyske").finish();
        modelAndView.addObject("article", ddHash.get(articleId));
        modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }
}
