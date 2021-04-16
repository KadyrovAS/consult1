import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(urlPatterns = "/registrationUser")
public class registrationUser extends HttpServlet{
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        DataBase.Users users = DataBase.INSTANCE.users;

    }

}
