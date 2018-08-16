package mobi.stos.youhub.util;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Weibson
 */
public class DistanceOnStreet {

    public Ota distance(double lat, double lng, double lat2, double lng2) {
        final double VELOCIDADE_MEDIA = 40.0;
        double distanciaHaversine = Util.haversine(lat, lng, lat2, lng2);
        long secondsHaverine = (long) ((distanciaHaversine / 1000) / VELOCIDADE_MEDIA);
        try {
            String urlString = new StringBuilder()
                    .append("http://maps.googleapis.com/maps/api/distancematrix/json?")
                    .append("origins=").append(lat).append(",").append(lng)
                    .append("&destinations=").append(lat2).append(",").append(lng2)
                    .append("&mode=driving&sensor=false")
                    .toString();

            URL url = new URL(urlString);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                JSONObject json = new JSONObject(Util.inputStreamToString(connection.getInputStream()));
                if (json.getString("status").equals("OK")) {
                    JSONObject elements = json.getJSONArray("rows").getJSONObject(0);
                    JSONArray array = elements.getJSONArray("elements");
                    double distance = array.getJSONObject(0).getJSONObject("distance").getDouble("value");
                    long duration = array.getJSONObject(0).getJSONObject("duration").getLong("value");
                    return new Ota(duration, distance);
                } else {
                    return new Ota(secondsHaverine, distanciaHaversine);
                }
            } else {
                return new Ota(secondsHaverine, distanciaHaversine);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Ota(secondsHaverine, distanciaHaversine);
        }
    }

    public class Ota {

        public long seconds;
        public double distance;

        public Ota(long seconds, double distance) {
            this.seconds = seconds;
            this.distance = distance;
        }

    }

}
