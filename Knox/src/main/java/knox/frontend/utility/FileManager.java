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
        csslist.add(new FrontEndFile(filename, FrontEndFile.FILETYPE.CSS));
        return this; 
    }

    public FileManager AddJSFile (String filename) {
        jslist.add(new FrontEndFile(filename, FrontEndFile.FILETYPE.JS));
        return this;
    }
    public FileManager AddLibraryFile (String filename) {
        jslist.add(new FrontEndFile(filename, FrontEndFile.FILETYPE.LIB));
        return this;
    }

    public void finish () {
        // Make sure to not over write allready added files
        if (model.getAttribute("CSSFiles") instanceof java.util.ArrayList){
            List<FrontEndFile> tempCSSFiles = (List<FrontEndFile>)model.getAttribute("CSSFiles");
            csslist.addAll(tempCSSFiles);
        }
        if (model.getAttribute("JSFiles") instanceof java.util.ArrayList){
            List<FrontEndFile> tempJSFiles = (List<FrontEndFile>)model.getAttribute("JSFiles");
            jslist.addAll(tempJSFiles);
        }
        model.addAttribute("CSSFiles",csslist);
        model.addAttribute("JSFiles",jslist);
    }

}


