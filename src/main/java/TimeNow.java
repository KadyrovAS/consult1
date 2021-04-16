import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/time")
public class TimeNow extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(
                "<html \n" +
                        "<head \n>" +
                        "    <meta charset=\"utf-8\"> \n" +
                        "</head> \n" +
                        "<body>" +
                        "    <div align='center'style=\"font-size:25px; color:green\"> \n" +
                        "        Привет от Progwards! <br>" +
                        "        Сейчас: " + new Date() +
                        "    </div> \n" +
                        "</body> \n" +
                "</html>"
        );
    }
}
