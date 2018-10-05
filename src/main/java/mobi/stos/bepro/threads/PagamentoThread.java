package mobi.stos.bepro.threads;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import mobi.stos.bepro.interfaces.IFutureCallback;
import java.net.HttpURLConnection;
import mobi.stos.bepro.bo.IUsuarioBo;
import org.json.JSONObject;

/**
 *
 * @author feito
 */
public class PagamentoThread extends Thread {

    private IFutureCallback callback;

    final private IUsuarioBo usuarioBo;

    public PagamentoThread(IUsuarioBo usuarioBo) {
        this.usuarioBo = usuarioBo;
    }

    public void onFutureCallback(IFutureCallback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {

        try {
            JSONObject json = new JSONObject();
            json.put("email", "Gilberto Alves Feitosa Junior");

            URL url = new URL("http://localhost:8084/bepro/rest/Default/fim");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            InputStream in = new BufferedInputStream(connection.getInputStream());
            String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            JSONObject jsonObject = new JSONObject(result);

            System.out.println("################################ result: " + result);
            System.out.println("################################# email: " + jsonObject.getString("email"));
            in.close();
            connection.disconnect();

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
