package knox.frontend.utility;

public class FrontEndFile {

  private String path;
  private FILETYPE filetype;

  public enum FILETYPE {
    CSS,
    JS,
    LIB,
  }

  public FrontEndFile(String path, FILETYPE filetype) {

    setPath(path);
    setFiletype(filetype);
  }

  private String getFileTypePostfix() {
    switch (filetype) {
      case CSS:
        return ".css";
      case JS:
      case LIB:
        return ".js";
      default:
        throw new Error("Missing filetype post fix");
    }
  }

  private String getFileTypePrefix() {
    String root = "/resources/";
    switch (filetype) {
      case CSS:
        return root + "style/";
      case JS:
        return root + "javascript/";
      case LIB:
        return root + "lib/";
      default:
        throw new Error("Missing filetype post fix");
    }
  }

  public String getPath() {
    return getFileTypePrefix() + path + getFileTypePostfix();
  }

  public void setPath(String path) {
    this.path = path;
  }

  public FILETYPE getFiletype() {
    return filetype;
  }

  public void setFiletype(FILETYPE filetype) {
    this.filetype = filetype;
  }
}
