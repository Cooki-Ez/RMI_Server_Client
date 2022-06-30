import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// **************************************************** Web Servlet ****************************************************
@WebServlet(name = "tpo04_controller", urlPatterns = "/addValues")
// *********************************************************************************************************************


public class Controller extends HttpServlet {
    private static final String COMPONENT_1 = "p1";
    private static final String COMPONENT_2 = "p2";
    private static final String MODEL = "model";



    private static final String ROUTE_TO_SERVLET = "/addValues/view";
    private static final String CHARSET = "UTF-8";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        request.setCharacterEncoding(CHARSET);
        String component_1 = request.getParameter(COMPONENT_1);
        String component_2 = request.getParameter(COMPONENT_2);
        Model model = Logic.processParameters(component_1, component_2);
        request.setAttribute(MODEL, model);
        RequestDispatcher dispatcher = request.getRequestDispatcher(ROUTE_TO_SERVLET);
        dispatcher.forward(request, response);
    }
}
