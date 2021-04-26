import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/mentorScheduleSave")
public class MentorScheduleSave extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fieldWeekDay;
        String fieldTimeStart;
        String fieldTimeDuration;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login=req.getParameter("login");
        for (int i = 1; i <= 7; i ++){
            fieldWeekDay = "weekday" + i;
            fieldTimeStart = "timestart" + i;
            fieldTimeDuration = "duration" + i;
            if (req.getParameter(fieldWeekDay) == null) continue;
            if (req.getParameter(fieldWeekDay).compareTo("on") == 0)
                schedulPut(login, i, req.getParameter(fieldTimeStart), req.getParameter(fieldTimeDuration));
        }
    }
    void schedulPut(String login, int weekDay, String timeStartStr, String timeDurationStr){
        long timeStart=0;
        long timeDuration;
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        try {
            timeStart = timeFormat.parse(timeStartStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeDuration = Long.valueOf(timeDurationStr);
        try {
            DataBase.INSTANCE.schedule.put(new DataBase.Schedule.Value(login, weekDay, timeStart, timeDuration));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
