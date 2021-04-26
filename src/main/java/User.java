import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/select")
public class User extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login.trim().compareTo("") == 0) {
            //введена пустая строка
            req.setAttribute("messageText", "Введите логин");
            req.setAttribute("endpoint","index.jsp");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        else if (password.trim().compareTo("") == 0){
            req.setAttribute("messageText", "Введите пароль");
            req.setAttribute("endpoint","index.jsp");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        else {
            DataBase.Users.User user = DataBase.INSTANCE.users.findKey(login);
            if (user == null) {
                String messageText = "Пользователь с логином " + login + " в базе данных отсутствует.";
                req.setAttribute("messageText", messageText);
                req.setAttribute("endpoint","index.jsp");
                getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            }
            else if(user.password.compareTo(password) != 0) {
                String messageText = "Вы ошиблись при вводе пароля! Попробуйте ввести пароль еще раз.";
                req.setAttribute("messageText", messageText);
                req.setAttribute("endpoint","index.jsp");
                getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("login", login);
                req.setAttribute("userName", user.name);
                if (user.is_mentor)
                    req.setAttribute("isMentor", "mentor");
                else
                    req.setAttribute("isMentor", "student");
                req.setAttribute("email", user.email);

                getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
            }
        }
    }
}