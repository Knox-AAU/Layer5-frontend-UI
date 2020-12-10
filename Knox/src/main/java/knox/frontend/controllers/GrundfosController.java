package knox.frontend.controllers;

import knox.frontend.models.Search;
import knox.frontend.utility.FileManager;
import knox.frontend.utility.GrundfosConnection;
import knox.frontend.utility.NordJyskeConnection;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/grundfos")
@Controller
public class GrundfosController extends  AbstractCompanyController {
    public GrundfosController() {
        super();
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView GetSearchPage(@RequestParam(name = "searched", defaultValue = "hello there Theis") String searchname, HttpServletResponse response){
        response.setContentType("application/json");
        Search search = new Search("Grundfos search engine", "Grundfos", "Nordjyske", "/nordjyske");
        ModelAndView modelAndView = new ModelAndView("Grundfos/GrundfosInterface");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("grundfos").finish();
        modelAndView.addObject("search", search);
        modelAndView.addObject("ddHash", ddHash);

        GrundfosConnection gc = new GrundfosConnection();
        String result = gc.Search(searchname);

        System.out.println("Result grundfoss for " + searchname + ": " + result);

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
