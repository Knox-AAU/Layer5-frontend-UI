package knox.frontend.models;

public class HeaderData {
    private String title;
    private String username;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static HeaderData CreateKnoxHeader (String username) {
        HeaderData headerData = new HeaderData();
        headerData.title = "Knox Hub";
        headerData.username = username;
        return headerData;
    }
    public static HeaderData CreateGrundfosHeader (String username) {
        HeaderData headerData = new HeaderData();
        headerData.title = "Knox: Grundfos";
        headerData.username = username;
        return headerData;

    }
}
