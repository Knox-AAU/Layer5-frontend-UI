package knox.frontend.models;

public class HubIcon {
    private String imagePath;
    private String title;
    private String link;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public HubIcon(String imagePath, String title, String link) {
        this.imagePath = imagePath;
        this.title = title;
        this.link = link;
    }
    public static HubIcon CreateGrundfosIcon (){
        String imagePath = "/resources/icons/Grundfos.png";
        String title = "Grundfos";
        String link = "grundfos";
        return new HubIcon(imagePath,title,link);
    }
    public static HubIcon CreateNordJyskeIcon (){
        String imagePath = "/resources/icons/NordJyske2.png";
        String title = "Nordjyske";
        String link = "nordjyske";
        return new HubIcon(imagePath,title,link);
    }
}
