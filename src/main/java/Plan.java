import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/plan")
public class Plan extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String userName = req.getParameter("userName");
        boolean isMentor = req.getParameter("isMentor").compareTo("mentor")==0 ? true : false;
        String email = req.getParameter("email");

        if (req.getParameter("button").compareTo("Сохранить") == 0) {
            //если была нажата кнопка сохранить
            DataBase.Users.User user = DataBase.INSTANCE.users.findKey(login);
            DataBase.INSTANCE.users.put(new DataBase.Users.User(login, user.password, user.needChangePassword,
                    userName, isMentor, email, user.progwardsAccountLink, user.discordName, user.image));
            req.setAttribute("login", login);
            req.setAttribute("userName", userName);
            if (isMentor)
                req.setAttribute("isMentor", "mentor");
            else
                req.setAttribute("isMentor", "student");
            req.setAttribute("email", email);

            getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
        }
        else if (isMentor){
            //если нажата кнопка консультации для преподавателя
        }
        else {
            //если нажата кнопка консультации для студента
        }
    }
}