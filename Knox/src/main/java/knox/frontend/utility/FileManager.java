package knox.frontend.utility;

import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final List<FrontEndFile> csslist;
    private final List<FrontEndFile> jslist;
    private final ModelMap model;
    public FileManager (ModelMap model) {
        this.model = model;
        csslist = new ArrayList<FrontEndFile>();
        jslist = new ArrayList<FrontEndFile>();
    }

    public FileManager AddCssFile (String filename) {
        csslist.add(new FrontEndFile("var", filename, FrontEndFile.FILETYPE.CSS));
        return this;
    }
    public FileManager AddJSFile (String filename) {
        jslist.add(new FrontEndFile("var", filename, FrontEndFile.FILETYPE.JS));
        return this;
    }


    public void finish () {
        model.addAttribute("CSSFiles",csslist);
        model.addAttribute("JSFiles",jslist);
    }

}


