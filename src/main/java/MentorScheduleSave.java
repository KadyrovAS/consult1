import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(urlPatterns = "/mentorScheduleSave")
public class MentorScheduleSave extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fieldWeekDay;
        String fieldTimeStart;
        String fieldTimeDuration;
        String erLine;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login=req.getParameter("login");
        for (int i = 1; i <= 7; i ++){
            fieldWeekDay = "weekday" + i;
            fieldTimeStart = "timestart" + i;
            fieldTimeDuration = "duration" + i;
            if (req.getParameter(fieldWeekDay) == null) {
                schedulDel(login, i);
                continue;
            }
            if (req.getParameter(fieldWeekDay).compareTo("on") != 0) continue;
            schedulDel(login, i);
            erLine = schedulPut(login, i, req.getParameter(fieldTimeStart), req.getParameter(fieldTimeDuration));
            if (erLine.compareTo("")==0) continue;
            req.setAttribute("messageText", erLine);
            req.setAttribute("endpoint","mentorSchedule.jsp");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
    void schedulDel(String login, int weekDay){
        DataBase.INSTANCE.schedule.select(x->x.getMentor().compareTo(login) == 0 && x.getDay_of_week() == weekDay).
                forEach(x-> {
                    try {
                        DataBase.INSTANCE.schedule.remove(new DataBase.Schedule.Key(x.mentor, x.day_of_week, x.start));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
    String schedulPut(String login, int weekDay, String timeStartStr, String timeDurationStr){
        long timeStart=0;
        long timeDuration;
        String message;
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        if (timeStartStr.compareTo("")==0) {

        }
        try {
            timeStart = timeFormat.parse(timeStartStr).getTime();
        } catch (ParseException e) {
            message = "Вы неправильно ввели время начала консультации";
            return message;
        }
        try {
            timeDuration = Long.valueOf(timeDurationStr);
        } catch (Throwable e) {
            message = "Вы неправильно ввели продолжительность консультации";
            return message;
        }

        try {
            DataBase.INSTANCE.schedule.put(new DataBase.Schedule.Value(login, weekDay, timeStart, timeDuration));
        } catch (IOException e){
        }

        return "";
    }
}
