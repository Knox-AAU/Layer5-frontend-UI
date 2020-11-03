package knox.frontend.controllers;
import knox.frontend.models.DummyData;
import knox.frontend.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class DatabaseSelectionController {
    HashMap<Integer, DummyData> ddHash = new HashMap<>();

    private DatabaseSelectionController(){
        for(int i = 0; i<10; i++){
            DummyData dd = new DummyData();
            ddHash.put(dd.getUniqueId(), dd);

        }
    }

    @RequestMapping(value = "/grundfos")
    public ModelAndView grundfoss(@RequestParam(name = "searched", defaultValue = "hello there Theis") String searchname){
        Search search = new Search("Grundfos search engine", "Grundfos", "Nordjyske", "/nordjyske");
        ModelAndView modelAndView = new ModelAndView("Grundfos/GrundfosInterface");
        modelAndView.addObject("search", search);
        modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }

    @RequestMapping(value = "/grundfos/search")
    public ModelAndView grundfos(@RequestParam(name = "article") int articleId){
        System.out.println("Hello there, Grundfos. Article id: " + articleId);
        ModelAndView modelAndView = new ModelAndView("Grundfos/GrundfosArticle");
        modelAndView.addObject("article", ddHash.get(articleId));
        modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }

    @RequestMapping(value = "/nordjyske")
    public ModelAndView nordjyske(@RequestParam(name = "searched", defaultValue = "hello there Theis") String searchname){
        System.out.println(searchname);
        Search search = new Search("Nordjyske search engine", "Nordjyske", "Grundfos", "/grundfos");
        ModelAndView modelAndView = new ModelAndView("Nordjyske/NordjyskeInterface");
        modelAndView.addObject("search", search);
        modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }


    @RequestMapping(value = "/nordjyske/search")
    public ModelAndView nordjyske(@RequestParam(name = "article") int articleId){
        System.out.println("Hello there, Nordjyske. Article id: " + articleId);
        ModelAndView modelAndView = new ModelAndView("Nordjyske/NordjyskeArticle");
        modelAndView.addObject("article", ddHash.get(articleId));
        modelAndView.addObject("ddHash", ddHash);
        return modelAndView;
    }


}
