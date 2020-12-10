package knox.frontend.controller;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import knox.frontend.model.Search;
import knox.frontend.model.NordjyskeResult;
import knox.frontend.model.Search;
import knox.frontend.utility.FileManager;
import knox.frontend.utility.NordJyskeConnection;
import org.apache.tools.ant.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RequestMapping(value = "/nordjyske")
@Controller
public class NordJyskController extends AbstractCompanyController {

    public NordJyskController() {
        super();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView GetSearchPage(@RequestParam(name = "object", defaultValue =  "") String object,
                                      @RequestParam(name = "subject", defaultValue = "") String subject,
                                      @RequestParam(name = "predicate", defaultValue = "") String predicate) throws JsonProcessingException {

        Search search = new Search("Nordjyske search engine", "Nordjyske", "Grundfos", "/grundfos");
        ModelAndView modelAndView = new ModelAndView("Nordjyske/NordjyskeInterface");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("nordjyske").finish();
        modelAndView.addObject("search", search);
        modelAndView.addObject("ddHash", ddHash);
        System.out.println("SEARCH STRINGS: " + object + subject + predicate);

        if(!object.equals("") || !subject.equals("") || !predicate.equals("")){
            NordJyskeConnection nc = new NordJyskeConnection();
            String result = nc.Search(object, subject, predicate);
            System.out.println("Result: " + result);

            final ObjectMapper objectMapper = new ObjectMapper();
            List<NordjyskeResult> searchResults = objectMapper.readValue(result, new TypeReference<List<NordjyskeResult>>() {
            });

            for(NordjyskeResult nr : searchResults){
                System.out.println("NR: " + nr.toString());
            }
            modelAndView.addObject("searchResults", searchResults);

        }
        return modelAndView;
    }


    @RequestMapping(value = "/search")
    public ModelAndView GetArticlePage(@RequestParam(name = "article") String articleFileName){
        System.out.println("Hello there, Nordjyske. Article id: " + articleFileName);
        ModelAndView modelAndView = new ModelAndView("Nordjyske/NordjyskeArticle");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        fileManager.AddCssFile("nordjyske").finish();

        NordJyskeConnection nc = new NordJyskeConnection();
        String article = nc.Article(articleFileName);

        System.out.println("Article: " + article);
        //modelAndView.addObject("article", ddHash.get(articleId));
        //modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }
}
