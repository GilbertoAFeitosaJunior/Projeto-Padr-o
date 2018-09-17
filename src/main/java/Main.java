
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Weibson
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-09-05 12:12:00"));
        System.out.println("###############" + calendar.getTimeInMillis());
    }

}
