package servlets;

import com.google.gson.Gson;
import exceptions.Tpo_05_exception;
import models.Resource;
import models.ResourceDetails;
import models.User;
import repositories.UserResourceRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/resourcesServlet", initParams = {
        @WebInitParam(name = "db_name", value = "jdbc/tpo_05_db")})
public class ResourcesServlet extends AbstractServlet {

    private static final String LOAD_RESOURCES = "loadResources";
    private static final String LOAD_RESOURCE_DETAILS = "loadDetails";

    private static final String RESOURCE_ID = "id_resource";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqType = req.getParameter(REQUEST_TYPE);
        resp.setCharacterEncoding(CHARSET);
        if (reqType.equals(LOAD_RESOURCES)) {
            loadResources(req, resp);
        } else if (reqType.equals(LOAD_RESOURCE_DETAILS)) {
            loadResourceDetails(req, resp);
        } else {
            throw new Tpo_05_exception("Illegal request");
        }
    }

    private void loadResources(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(USER);

        resp.setContentType(TEXT_JSON_TYPE);
        List<Resource> resources = UserResourceRepository.getAvailableResources(user, dataSource);
        String resourcesJson = new Gson().toJson(resources);
        resp.getWriter().write(resourcesJson);
    }

    private void loadResourceDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter(RESOURCE_ID));
        ResourceDetails resourceDetails = UserResourceRepository.getResourceDetails(id, dataSource);
        resp.setContentType(TEXT_JSON_TYPE);
        String detailsJson = new Gson().toJson(resourceDetails);
        resp.getWriter().write(detailsJson);
    }

}
