package exercise.servlet;

//import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
//import java.util.Objects;
//import java.util.List;
//import java.util.stream.Collectors;
import static exercise.Data.getCompanies;
//import static java.lang.System.out;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        String searchValue = request.getParameter("search");

        var companies = getCompanies();
        var companiesOutput = new ArrayList<>();

        PrintWriter pw = response.getWriter();
        StringBuilder r = new StringBuilder();

        if (searchValue == null) {
            pw.println(r.toString().replaceAll("\\R$", ""));
        } else {
            for (var companie : companies) {
                if (companie.contains(searchValue)) {
                    companiesOutput.add(companie);
                    r.append(companie).append("\n");
                }
            }
            if (companiesOutput.equals(new ArrayList<>())) {
                pw.println("Companies not found");
            } else {
                pw.println(r.toString().replaceAll("\\R$", ""));
            }
        }

        if (request.getQueryString() == null) {

            for (var companie : companies) {
                r.append(companie).append("\n");
            }
            pw.println(r.toString().replaceAll("\\R$", ""));
        }
        // END
    }
}
