import javax.servlet.ServletContext;
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
        ServletContext servletContext = getServletContext();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String buttonName = req.getParameter("button");
        if (buttonName.compareTo("Cancel") == 0) return;

//        if (DataBase.INSTANCE.users.put(new DataBase.Users.User(login, password, "", false, ""))) {

        req.setAttribute("login", login);
            getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
//        }
//        else {
//            DataBase.Users.User user = DataBase.INSTANCE.users.findKey(login);
//            if (user.is_mentor) {
//
//            }
//        }
    }
}
