package com.needtostudy.gongzza.push;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;

@Service
public class PushService {

    private static String FIREBASE_SERVER_KEY = "AAAAqMamTD8:APA91bGPLjGGDOx_GLcZtUa1IlxacOYhxiojxdLOJbuME6OQ1pUnfHjpCle6hRGH6XhFHso6F32oGQE2z_4IPPOmlZYkAmxK96LO5egybtkQORRezCFSSSKH8_BC9K1mEOnOALwos2US";

    private FirebaseApp firebaseApp;

    public PushService() {
        authExplicit(getClass().getClassLoader().getResource("gongzza-7492c-firebase-adminsdk-wlirl-9c5d1871ca.json").getFile());
    }

    private void authExplicit(String jsonPath) {
        try {
            FileInputStream serviceAccountFile = new FileInputStream(jsonPath);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccountFile))
                    .setDatabaseUrl("https://gongzza-7492c.firebaseio.com")
                    .build();

            try {
                firebaseApp = FirebaseApp.getInstance();
            } catch (IllegalStateException e) {
                firebaseApp = FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    @Autowired
//    private TokenDao tokenDao;
//
//    private static final String SERVER_KEY = "AAAA3mbFxlM:APA91bH7ePjf9A3xL1Ccj3lOWwmxca7Buq0cC-ysImaxeMEDy8Nn0NQpEeqC5ceeB3c36EUMNRXr-VPaw--xBem8UUTO2ih_OSzw33Hyk3i1GNlCfcKHBDJHd5fKbryEi5rISxQSVvrQ";
//
//    private FirebaseApp firebaseApp;
//
//    public PushService() {
//        authExplicit(getClass().getClassLoader().getResource("mn09-f13c1-firebase-adminsdk-o62a0-b88b413be0.json").getFile());
//    }
//
//    void authExplicit(String jsonPath) {
//        try {
//            FileInputStream serviceAccount =
//                    new FileInputStream(jsonPath);
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
////                .setDatabaseUrl("https://mn09-f13c1.firebaseio.com")
//                    .build();
//
//            try {
//                firebaseApp = FirebaseApp.getInstance();
//            } catch (IllegalStateException e) {
//                firebaseApp = FirebaseApp.initializeApp(options);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void push(Push push) throws Exception {
//        List<Token> tokenList = tokenDao.selectAllUsersByServiceId(push.getServiceId());
//        List<String> tokenStringList = new ArrayList<String>();
//        for (Token token : tokenList) {
//            tokenStringList.add(token.getToken());
//        }
//
//        MulticastMessage message = MulticastMessage.builder()
//                .putData("url", push.getUrl())
//                .putData("title", push.getTitle())
//                .putData("content", push.getContent())
//                .putData("imageUrl", push.getImageUrl())
//                .setNotification(
//                        new Notification(
//                                push.getTitle(),
//                                push.getContent(),
//                                push.getImageUrl()
//                        )
//                )
//                .setApnsConfig(ApnsConfig.builder()
//                        .setAps(Aps.builder()
//                                .setMutableContent(true)
//                                .setContentAvailable(true)
//                                .build())
//                        .setFcmOptions(
//                                ApnsFcmOptions.builder()
//                                        .setImage(push.getImageUrl())
//                                        .build())
//                        .build())
//                .addAllTokens(tokenStringList)
//                .build();
//
//        BatchResponse response = FirebaseMessaging.getInstance(firebaseApp).sendMulticast(message);
//        System.out.println("Push Success " +response.getSuccessCount() + "/" + tokenList.size());
//    }
}
