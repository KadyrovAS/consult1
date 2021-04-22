import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sel")
public class Select extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        DataBase.INSTANCE.users.readAll();
        if (!DataBase.INSTANCE.users.exists(login)) {
            req.setAttribute("login-description", login);
//        String password = req.getParameter("password");
//        req.setAttribute("password-description", password);
            req.getRequestDispatcher("newUser.jsp").forward(req, resp);
        }
        else {

        }
    }
}
