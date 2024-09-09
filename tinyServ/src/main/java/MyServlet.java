import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/aboutme")
public class MyServlet extends HttpServlet {
    private String name, interests;

    @Override
    public void init() {
        name = "Tom";
        interests = "eating fish and going after Jerry!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "About me" + "</h1>");
        out.println("<h3>" + "My name: " + name + "</h3>");
        out.println("<h3>" + "My hobbies: " + interests + "</h3>");
        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println(request.getParameter("lyrics"));
    }
}
