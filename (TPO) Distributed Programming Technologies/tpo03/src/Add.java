
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/add/")

public class Add extends HttpServlet {
    private static final long serialVersionUID = 884041425700900768L;

    private static final String COMPONENT1 ="component1";
    private static final String COMPONENT2 ="component2";
    private static final String INTEGER_PATTERN="^-?[0-9]+$";
    private static final Pattern INTEGER_REGEX = Pattern.compile(INTEGER_PATTERN);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        serviceImpl(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                    throws ServletException, IOException{
        serviceImpl(request, response);
    }


    private void serviceImpl(HttpServletRequest request, HttpServletResponse response)
                                    throws ServletException, IOException{


        String input1 = request.getParameter(COMPONENT1);
        String input2 =request.getParameter(COMPONENT2);

        BigInteger component1 = value(input1);
        BigInteger component2 = value(input2);
        PrintWriter writer = response.getWriter();

        if (component1 !=null && component2 !=null) {
            print(writer, component1, component2);
           // response.getWriter().print(writer,component1,component2);
        }else {
            error(writer, input1, input2);
        }
        writer.close();
        }



    private static BigInteger value(String input) {

        Matcher matcher = INTEGER_REGEX.matcher(input);
        if (!matcher.matches()) {
            return null;

        }
        return new BigInteger(input);
    }

    public void print(PrintWriter writer, BigInteger component1, BigInteger component2){
        BigInteger sum = component1.add(component2);
        writer.print("Sum: "+sum);
    }
    private void error(PrintWriter writer, String input1, String input2){
        writer.printf("Invalid input(Component1: %s, component2: %s)", input1, input2);
    }
}