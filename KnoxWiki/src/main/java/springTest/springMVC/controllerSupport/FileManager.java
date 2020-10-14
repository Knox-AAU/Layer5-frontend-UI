package springTest.springMVC.controllerSupport;

import org.springframework.ui.ModelMap;
import springTest.springMVC.datatypes.frontendfile;


import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<frontendfile> csslist;
    private ModelMap model;
    public FileManager (ModelMap model) {
        this.model = model;
        csslist = new ArrayList<frontendfile>();
    }

    public FileManager AddCssFile (String filename) {
        csslist.add(new frontendfile("var", filename, frontendfile.FILETYPE.CSS));
        return this;
    }

    public void finish () {
        model.addAttribute("CSSFiles",csslist);

    }
}
