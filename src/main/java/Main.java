
import java.util.Calendar;
import java.util.Date;



/**
 *
 * @author Weibson
 */
public class Main {

    public static void main(String[] args) throws Exception {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());

      
        
        System.out.println("data: " + calendar.getTimeInMillis());
               
       
    }

}
