package mobi.stos.bepro.threads;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.ApsAlert;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Weibson
 */
public class FCMThread extends Thread {

    public static final String TITLE = "title";
    public static final String BODY = "body";
    public static final String ACTION = "action";
    public static final String IMAGE = "image";
    public static final String BADGE = "badge";

    private final String title;
    private final String body;
    private final String action;

    private String image;
    private String badge;

    private final List<String> pushs = new ArrayList<>();
    private final Map<String, String> data = new HashMap<>();

    public FCMThread(String title, String body, String action) {
        this.title = title;
        this.body = body;
        this.action = action;
    }

    public void setPushs(List<String> pushs) {
        this.pushs.addAll(pushs);
    }

    public void setPush(String push) {
        this.pushs.add(push);
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public void addData(String key, Object value) {
        this.data.put(key, String.valueOf(value));
    }

    @Override
    public void run() {
        super.run();

        try {
            this.data.put(TITLE, title);
            this.data.put(BODY, body);
            this.data.put(ACTION, action);
            if (StringUtils.isNotBlank(this.image)) {
                this.data.put(IMAGE, image);
            }

            boolean exists = FirebaseApp.getApps() != null && !FirebaseApp.getApps().isEmpty();

            if (!exists) {
                URL resource = FCMThread.class.getClassLoader().getResource("serviceAccountKey.json");

                FileInputStream serviceAccount = new FileInputStream(new File(resource.toURI()));
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://bepro-stos.firebaseio.com")
                        .build();
                FirebaseApp.initializeApp(options);
            }

            FirebaseMessaging messaging = FirebaseMessaging.getInstance();
            for (String push : pushs) {
                try {
                    Message message = Message.builder()
                            .putAllData(data)
                            .setToken(push)
                            .setNotification(new Notification(title, body))
                            .setAndroidConfig(AndroidConfig.builder()
                                    .setTtl(3600 * 1000)
                                    .setNotification(AndroidNotification.builder()
                                            .setIcon("ic_stat_logo")
                                            .setColor("#fa2698")
                                            .build())
                                    .build())
                            .setApnsConfig(ApnsConfig.builder()
                                    .putHeader("apns-priority", "10")
                                    .setAps(Aps.builder()
                                            .setAlert(ApsAlert.builder()
                                                    .setBody(body)
                                                    .setTitle(title)
                                                    .build())
                                            .setBadge(1)
                                            .setContentAvailable(true)
                                            .build())
                                    .build())
                            .build();
                    String response = messaging.send(message);
                    System.out.println(response);
                } catch (FirebaseMessagingException exception) {
                    exception.printStackTrace();
                    switch (exception.getErrorCode()) {
                        case "invalid-registration-token":
                        case "registration-token-not-registered":
                            System.out.println(exception.getErrorCode());
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
