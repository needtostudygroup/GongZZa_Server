package com.needtostudy.gongzza.push;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import com.needtostudy.gongzza.daos.TokenDao;
import com.needtostudy.gongzza.participant.ParticipantService;
import com.needtostudy.gongzza.post.PostService;
import com.needtostudy.gongzza.vos.ChatLog;
import com.needtostudy.gongzza.vos.Participant;
import com.needtostudy.gongzza.vos.Post;
import com.needtostudy.gongzza.vos.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PushService {

    private static String FIREBASE_SERVER_KEY = "AAAAqMamTD8:APA91bGPLjGGDOx_GLcZtUa1IlxacOYhxiojxdLOJbuME6OQ1pUnfHjpCle6hRGH6XhFHso6F32oGQE2z_4IPPOmlZYkAmxK96LO5egybtkQORRezCFSSSKH8_BC9K1mEOnOALwos2US";

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private PostService postService;

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

    public void push(ChatLog chatLog) throws Exception {
        List<Participant> participantList = participantService.selectParticipantListByPostId(chatLog.getPostId());
        Post post = postService.selectPostDtoById(chatLog.getPostId());

        List<String> tokenList = new ArrayList<String>();
        for (Participant participant : participantList) {
            List<Token> participantsTokenList = tokenDao.selectTokenByUserId(participant.getUser().getId());
            if (participantsTokenList != null) {
                for (Token token : participantsTokenList) {
                    System.out.println("token = " + token.getToken());
                    tokenList.add(token.getToken());
                }
            }
        }

        MulticastMessage message = MulticastMessage.builder()
                .addAllTokens(tokenList)
                .putData("POST", String.valueOf(chatLog.getPostId()))
                .putData("SENDER", chatLog.getSenderId())
                .putData("ID", String.valueOf(chatLog.getId()))
                .setNotification(new Notification(
                        post.getTitle(), chatLog.getContent()
                ))
                .build();

        BatchResponse response = FirebaseMessaging.getInstance(firebaseApp).sendMulticast(message);
        for (SendResponse res : response.getResponses()) {
            System.out.println(res.getMessageId());
        }
    }
}
