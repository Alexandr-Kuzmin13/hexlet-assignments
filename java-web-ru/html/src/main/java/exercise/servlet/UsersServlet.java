package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);

    }

    private List<Map<String, String>> getUsers() throws IOException {
        // BEGIN
        ObjectMapper mapperJson = new ObjectMapper();
        Path path = Paths.get("src/main/resources/users.json").toAbsolutePath().normalize();
        var content = Files.readString(path);

        return mapperJson.readValue(content, new TypeReference<>() {});
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        StringBuilder str = new StringBuilder();

        PrintWriter pw = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");

        for (var user: getUsers()) {

            var fullName = user.get("firstName") + " " + user.get("lastName");
            var id1 = user.get("id");

            str.append(String.format("""
            <!DOCTYPE html>
            <html lang=\"ru\">
                <head>
                    <meta charset=\"UTF-8\">
                    <title>Example application</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                </head>
                <body>
                    <div class=\"container\">
                        <a href=\"/users/%s\">%s</a>
                    </div>
                </body>
            </html>
            """, id1, fullName)).append("\n");
        }
        pw.println(str.toString().replaceAll("\\R$", ""));
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        StringBuilder str = new StringBuilder();

        PrintWriter pw = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");

        for (var user: getUsers()) {

            var firstName = user.get("firstName");
            var lastName = user.get("lastName");
            var idAnswer = user.get("id");
            var email = user.get("email");

            if (Objects.equals(idAnswer, id)) {
                str.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link rel=\"stylesheet\" href=\"mysite.css\">
                    </head>
                    <body>
                    """).append("\n");
                str.append("<p>").append(firstName).append("</p>").append("\n");
                str.append("<p>").append(lastName).append("</p>").append("\n");
                str.append("<p>").append(email).append("</p>").append("\n");
                str.append("""
                    </body>
                </html>
                """);
            }
        }

        pw.println(str.toString().replaceAll("\\R$", ""));

        if (Objects.equals(id, "") || Objects.equals(id, "101")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        // END
    }
}
