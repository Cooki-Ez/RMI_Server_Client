//package filters;
//
//import models.User;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.regex.Pattern;
//
//@WebFilter(value = "/*", initParams = {
//        @WebInitParam(name = "login_page", value = "/login.html"),
//        @WebInitParam(name = "resource_page", value = "/htmlResources/resourceList.html")
//
//})
//public class LoginFilter extends HttpFilter {
//
//    private static final String USER = "user";
//    private static final String LOGIN_PAGE = "login_page";
//    private static final String RESOURCE_PAGE = "resource_page";
//
//    private String loginPage;
//    private String resourcePage;
//
//    @Override
//    public void init() throws ServletException {
//        loginPage = getInitParameter(LOGIN_PAGE);
//        resourcePage = getInitParameter(RESOURCE_PAGE);
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        HttpServletResponse httpResponse = (HttpServletResponse) resp;
//
//        boolean loggedIn = isLoggedIn(httpRequest);
//        boolean logInRequest = isLogInRequest(httpRequest, httpResponse);
//        boolean staticResource = isStaticResource(httpRequest);
//
////        if (loggedIn && logInRequest) {
////            System.out.println(1);
////            httpResponse.sendRedirect(resourcePage);
//        /*} else */if (loggedIn || logInRequest || staticResource) {
//            System.out.println(2);
//            chain.doFilter(req, resp);
//        } else {
//            System.out.println(3);
//            httpResponse.sendRedirect(loginPage);
//        }
//
//    }
//
//    private boolean isLogInRequest(HttpServletRequest req, HttpServletResponse resp) {
//        return req.getRequestURI().equals(req.getContextPath() + loginPage) || req.getRequestURI().equals(req.getContextPath());
//    }
//
//    private boolean isLoggedIn(HttpServletRequest req) throws IOException {
//        HttpSession session = req.getSession(false);
//        if (session == null || session.getAttribute(USER) == null) {
//            return false;
//        }
//        return true;
//    }
//
//
//    private boolean isStaticResource(HttpServletRequest req) {
//        String reqest = req.getRequestURI();
//        return Pattern.compile(".*/htmlResources/.*(?<!\\.html)$").matcher(reqest).matches();
//    }
//
//}
