package knox.frontend.utility;

import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<FrontEndFile> csslist;
    private ModelMap model;
    public FileManager (ModelMap model) {
        this.model = model;
        csslist = new ArrayList<FrontEndFile>();
    }

    /*
    public FileManager AddCssFile (String filename) {
        csslist.add(new FrontEndFile("var", filename, FrontEndFile.FILETYPE.CSS));
        return this;
    }
    
     */
    public void AddCssFile (String filename) {
        csslist.add(new FrontEndFile("var", filename, FrontEndFile.FILETYPE.CSS));
    }
    public void finish () {
        model.addAttribute("CSSFiles",csslist);

    }

}



