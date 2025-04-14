import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Forms")
public class Forms extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "GET");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "POST");
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response, String method)
            throws IOException {
        response.setContentType("text/html");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>Form Submitted using " + method + " Method</h1>");
            out.println("<p>First Name: " + firstName + "</p>");
            out.println("<p>Last Name: " + lastName + "</p>");
            out.println("</body></html>");
        }
    }
}      