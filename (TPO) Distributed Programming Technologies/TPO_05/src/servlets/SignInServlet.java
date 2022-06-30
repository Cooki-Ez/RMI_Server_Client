package servlets;

import exceptions.Tpo_05_exception;
import models.User;
import repositories.UserResourceRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/signInServlet", initParams = {
        @WebInitParam(name = "db_name", value = "jdbc/tpo_05_db")})
public class SignInServlet extends AbstractServlet {

    private static final String SIGN_IN_REQUEST = "signIn";
    private static final String LOGOUT_REQUEST = "logout";

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private static final int OK_STATUS = 200;
    private static final int NO_SUCH_USER_STATUS = 204;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqType = req.getParameter(REQUEST_TYPE);
        if(reqType.equals(SIGN_IN_REQUEST)) {
            signIn(req, resp);
        } else if(reqType.equals(LOGOUT_REQUEST)) {
            logout(req, resp);
        } else {
            throw new Tpo_05_exception("Illegal request");
        }
    }

    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(CHARSET);
        String usrLogin = req.getParameter(LOGIN);
        String usrPassword = req.getParameter(PASSWORD);

        User usr = UserResourceRepository.getUserByLoginPassword(usrLogin, usrPassword, dataSource);
        if (usr == null) {
            resp.setStatus(NO_SUCH_USER_STATUS);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute(USER, usr);
            session.setMaxInactiveInterval(120);
            resp.setStatus(OK_STATUS);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        resp.setStatus(200);
    }

}
