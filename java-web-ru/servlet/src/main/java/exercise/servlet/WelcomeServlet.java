package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// BEGIN
public final class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        out.println("Hello, World!");
    }
}
// END
