import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@WebServlet(urlPatterns = "/plan")
public class Plan extends HttpServlet {
    String comandLine ="";

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
            req.setAttribute("login", login);
            req.setAttribute("userName",userName);
            List<DataBase.Schedule.Value> scheduleList =
                    DataBase.INSTANCE.schedule.select(x->x.mentor.compareTo(login)==0);
            comandLine = "";
            createTable(scheduleList);
            req.setAttribute("tableLine",comandLine);
            getServletContext().getRequestDispatcher("/mentorSchedule.jsp").forward(req, resp);
        }
        else {
            //если нажата кнопка консультации для студента
            req.setAttribute("userName", userName);
            req.setAttribute("login", login);
            List<DataBase.Users.User>users = DataBase.INSTANCE.users.select(x->x.is_mentor);
            comandLine ="";
            users.forEach(x-> comandLine += "<option value=" + "\"" + x.login + "\"" +
                    ">" + x.name+"</option>");
            req.setAttribute("mentorNames", comandLine);

            getServletContext().getRequestDispatcher("/choiceMentor.jsp").forward(req, resp);
        }
    }

    void createTable(List<DataBase.Schedule.Value>values){
        for (int i = 1; i <= 7; i ++) {
            comandLine += "<tr><td><input type=\"checkbox\" name=\"weekday" + i + "\" id=\"weekday" + i + "\"";
            if (mentorBusy(values, i)) comandLine += " checked ";
            comandLine += ">";
            comandLine += "<label for=\"weekday\"" + i + ">" + weekDay(i) + "</label></td>";
            comandLine += "<td><input type=\"text\" name=\"timestart" + i +
                    "\" value=" + "\"" + getTimeStart(values, i) +"\"></td>";

            comandLine += "<td><input type=\"text\" name=\"duration" + i +
                    "\" value=" + "\"" + getDuration(values, i) +"\"></td></tr>";

        }
    }

    boolean mentorBusy(List<DataBase.Schedule.Value>values, int n){
    for (DataBase.Schedule.Value value : values)
        if (value.getDay_of_week() == n) return true;
    return false;
    }

    Long getDuration(List<DataBase.Schedule.Value>values, int n){
        for (DataBase.Schedule.Value value : values)
            if (value.getDay_of_week() == n) return value.getDuration();
        return 0L;
    }

    String getTimeStart(List<DataBase.Schedule.Value>values, int n) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        for (DataBase.Schedule.Value value : values)
            if (value.getDay_of_week() == n) {
                cal.setTimeInMillis(value.getStart());
                return format.format(cal.getTime());
            }
        return "";
    }

    String weekDay(int n){
        switch (n){
            case 1: return "Понедельник";
            case 2: return "Вторник";
            case 3: return "Среда";
            case 4: return "Четверг";
            case 5: return "Пятница";
            case 6: return "Суббота";
            case 7: return "Воскресенье";
            default: return null;
        }
    }
}