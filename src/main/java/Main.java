
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Weibson
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-09-24 19:00:00").getTime());

        System.out.println("data: " + calendar.getTimeInMillis());

    }

}
