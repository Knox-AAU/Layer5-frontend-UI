package knox.frontend.utility;

public class Uservalidator {

   public static Boolean  ValidateLogin(String username ,String password)
    {

        if (username.equals("grundfos") && password.equals("grundfos")){
            return true;
        }
        else if (username.equals("nordjyske") && password.equals("nordjyske")){
            return true;
        }
        else if (username.equals("both") && password.equals("both")){
            return true;
        }
        else {
            return false;
        }
    }
}
