package springTest.springMVC.datatypes;

import org.springframework.beans.factory.annotation.Value;

public class frontendfile {
    public enum FILETYPE {
        CSS,
        JS
    }
    public frontendfile (String variable, String path, FILETYPE filetype) {
        setVariable(variable);
        setPath(path);
        setFiletype(filetype);
    }
    private String getFileTypePostfix (){
        switch (filetype){
            case CSS: return ".css";
            case JS: return ".js";
            default: throw new Error("Missing filetype post fix");
        }
    }
    private String getFileTypePrefix (){
        String root = "/resources/";
        switch (filetype){
            case CSS: return root + "style/";
            case JS: return root + "JavaScript/";
            default: throw new Error("Missing filetype post fix");
        }
    }
    public String getPath() {
        return getFileTypePrefix() +  path + getFileTypePostfix();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public FILETYPE getFiletype() {
        return filetype;
    }

    public void setFiletype(FILETYPE filetype) {
        this.filetype = filetype;
    }

    private String variable;
    private String path;
    private FILETYPE filetype;
}
