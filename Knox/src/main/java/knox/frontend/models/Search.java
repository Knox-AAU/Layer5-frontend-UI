package knox.frontend.models;

public class Search {
    private String title; //Page title
    private String name;  //Name of search engine

    private String buttonName; //Name of button, that leads to the other search engine
    private String buttonUrl;  //Url of that button

    public Search(String title, String name, String buttonName, String buttonUrl){
        this.title = title;
        this.name = name;
        this.buttonName = buttonName;
        this.buttonUrl = buttonUrl;
    }


    public String getTitle(){
        return title;
    }

    public String getName(){
        return name;
    }
    public String getButtonName(){
        return buttonName;
    }
    public String getButtonUrl(){
        return buttonUrl;
    }
}
