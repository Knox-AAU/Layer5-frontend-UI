package knox.frontend.utility;

public class Uservalidator {

   public static Boolean  ValidateLogin(String username ,String password)
    {

        if (username == "grundfos" && password == "grundfos"){
            return true;
        }
        else if (username == "nordjyske" && password == "nordjyske"){
            return true;
        }
        else if (username == "both" && password == "both"){
            return true;
        }
        else {
            return false;
        }
    }
}
