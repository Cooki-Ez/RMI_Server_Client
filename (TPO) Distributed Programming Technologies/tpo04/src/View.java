import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


// **************************************************** Web Servlet ****************************************************
@WebServlet
        (name = "tpo04_view", urlPatterns = "/addValues/view", initParams = {
        @WebInitParam(name = "formFile", value = "addParameters.html"),
        @WebInitParam(name = "missingParameters", value = "missingParameters.html"),
        @WebInitParam(name = "wrongParameters", value = "wrongParameters.html")
})
// *********************************************************************************************************************


public class View extends HttpServlet {
    private static final String MODEL = "model";
    private static final String FORM_FILE = "formFile";
    private static final String HTML_HEAD = "<html>\n<head><title>tpo04</title></head>\n<body>";
    private static final String HTML_ENDING = "</body>\n</html>";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }



    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Model model = (Model) req.getAttribute(MODEL);
        PrintWriter writer = resp.getWriter();

        writer.write(HTML_HEAD);
        String formFileName = getInitParameter(FORM_FILE);
        printFile(writer, formFileName);
        writer.print("<hr><hr><hr>");

        if (model.getRespType() == ResponseType.OK) {
            writer.write("<h1>RESULT = ");
            writer.write(model.getResult().toString());
            writer.write("</h1>");
        } else {
            String errorFileName = getInitParameter(model.getRespType().response);
            printFile(writer, errorFileName);
        }
        writer.print(HTML_ENDING);
        writer.close();
    }

    private void printFile(PrintWriter writer, String fileName) throws IOException {
        ServletContext context = getServletContext();
        try (InputStream in = context.getResourceAsStream("/htmlComponents/" + fileName)) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                for (String line; (line = br.readLine()) != null; ) {
                    writer.println(line);
                }
            }
        }
    }
}