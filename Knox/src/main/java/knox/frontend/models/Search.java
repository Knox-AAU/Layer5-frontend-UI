package knox.frontend.models;

public class Search   {



    private final String pageTitle; //Page title
    private final String databaseName;  //Name of search engine
    private final String buttonName; //Name of button, that leads to the other search engine
    private final String buttonUrl;  //Url of that button

    public Search(String pageTitle, String databaseName, String buttonName, String buttonUrl){
        this.pageTitle = pageTitle;
        this.databaseName = databaseName;
        this.buttonName = buttonName;
        this.buttonUrl = buttonUrl;
    }

    public String getPageTitle(){
        return pageTitle;
    }
    public String getDatabaseName(){
        return databaseName;
    }
    public String getButtonName(){
        return buttonName;
    }
    public String getButtonUrl(){
        return buttonUrl;
    }





}
