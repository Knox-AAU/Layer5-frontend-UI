package springTest.springMVC.security;

public class LoginValidator {

  public static boolean ValidatLogin(String username, String password) {
    if (username.equals("test") && password.equals("test")) return true;

    return false;
  }
}
