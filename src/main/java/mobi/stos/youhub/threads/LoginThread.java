package mobi.stos.youhub.threads;

import java.io.InputStream;
import java.net.URL;
import mobi.stos.youhub.interfaces.IFutureCallback;
import java.net.HttpURLConnection;
import mobi.stos.youhub.restful.model.Login;
import mobi.stos.youhub.util.Util;
import org.json.JSONObject;

/**
 *
 * @author feito
 */
public class LoginThread extends Thread {

    final private Login login;
    private IFutureCallback callback;

    public LoginThread(Login login) {
        this.login = login;
    }

    public void onFutureCallback(IFutureCallback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {

        try {

            URL url = new URL("http://ti.hyper.jobs/patrick.castro/api-netmarketing/partnerEvent/login/" + login.getLogin() + "/" + login.getSenha());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();

            String jsonString = Util.inputStreamToString(inputStream);

            JSONObject json = new JSONObject(jsonString);
            System.out.println("################################# returno: " + json.getString("msg"));

            System.out.println("################################# returno: " + json.getBoolean("return"));

            if (callback != null) {
                callback.onSuccess();
            }
        } catch (Exception ex) {
            if (callback != null) {
                callback.onError(ex);
            }
        }
    }

}
