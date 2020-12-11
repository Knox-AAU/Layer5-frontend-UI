package knox.frontend.interceptor;

import knox.frontend.model.UserData;
import knox.frontend.utility.FileManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Interceptor");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post Interceptor");
        FileManager fileManager = new FileManager(modelAndView.getModelMap());
        // Added JavaScript files
        fileManager.AddLibraryFile("jquery-3.5.1.min").AddJSFile("ajax-post-controller").AddJSFile("Dropdown").AddJSFile("sidebarhandeling");
        // Added CCS files
        fileManager.AddCssFile("general").AddCssFile("sidebar").AddCssFile("header");
        fileManager.finish();

        // Set up user data
        modelAndView.addObject("Header", UserData.CreateKnoxHeader());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("After Interceptor");
    }
}

/*

    <spring:url value="/resources/lib/jquery-3.5.1.min.js" var="jquary" />
    <script src="${jquary}"></script>

    <spring:url value="/resources/javascript/ajax-post-controller.js" var="ajax" />
    <script src="${ajax}"></script>


    <spring:url value="/resources/javascript/Dropdown.js" var="DropDown" />
    <script src="${DropDown}"></script>


    <spring:url value="/resources/style/general.css" var="style" />
    <link rel="stylesheet" href="${style}">

    <spring:url value="/resources/style/sidebar.css" var="style" />
    <link rel="stylesheet" href="${style}">
    <spring:url value="/resources/style/header.css" var="style" />
    <link rel="stylesheet" href="${style}">

 */