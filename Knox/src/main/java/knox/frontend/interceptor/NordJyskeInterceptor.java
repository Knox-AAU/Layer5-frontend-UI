package knox.frontend.interceptor;

import knox.frontend.utility.FileManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NordJyskeInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("NordJyske Pre Interceptor");
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {

    FileManager fileManager = new FileManager(modelAndView.getModelMap());
    fileManager.AddCssFile("nordjyske").finish();
    modelAndView.addObject("CurrentDatabase", "NordJyske");

    System.out.println("NordJyske Post Interceptor");
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    System.out.println("NordJyske After Interceptor");
  }
}
