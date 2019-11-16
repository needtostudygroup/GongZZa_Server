package com.needtostudy.gongzza.authMail;

import com.needtostudy.gongzza.daos.AuthMailDao;
import com.needtostudy.gongzza.vos.AuthMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;

@Service
public class AuthMailServiceImpl implements AuthMailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private AuthMailDao authMailDao;

    @Transactional
    public AuthMail createAuthMail(String userId, String email) throws Exception {
        AuthMail authMail = new AuthMail(userId, email);
        authMailDao.createAuthMail(authMail);
        sendMail(authMail);
        return authMailDao.selectAuthMail(authMail.getUserId(), authMail.getEmail());
    }

    public AuthMail selectAuthMailByCode(String userId, String email, String code) {
        return authMailDao.selectAuthMailByCode(userId, email, code);
    }

    public void deleteAuthMail(String userId, String email) {
        authMailDao.deleteAuthMail(userId, email);
    }

    public void sendMail(final AuthMail authMail) {
        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                helper.setFrom("gongzza.co.kr");
                helper.setTo(authMail.getEmail());
                helper.setSubject("[공짜] 계정 인증 받으세요! " + authMail.getUserId() + "님");
                helper.setText("<a href=\"http://localhost:1234/authMails/users/" +
                        authMail.getUserId() + "/email/" +
                        authMail.getEmail() + "/code/" + authMail.getCode() + "\">Click here!</a>", true);
            }
        };

        mailSender.send(preparator);
    }
}
