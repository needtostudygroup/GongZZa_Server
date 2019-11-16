package com.needtostudy.gongzza.authMail;

import com.needtostudy.gongzza.daos.AuthMailDao;
import com.needtostudy.gongzza.daos.AuthedAccountDao;
import com.needtostudy.gongzza.daos.UserDao;
import com.needtostudy.gongzza.vos.AuthMail;
import com.needtostudy.gongzza.vos.AuthedAccount;
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

    @Autowired
    private AuthedAccountDao authedAccountDao;

    @Autowired
    private UserDao userDao;

    @Transactional
    public AuthMail createAuthMail(String userId, String email) throws Exception {
        if (userDao.selectUserById(userId) != null || authedAccountDao.selectAuthedAccountById(userId) != null ||
            userDao.selectUserByEmail(email) != null || authedAccountDao.selectAuthedAccountByEmail(email) != null)
            throw new Exception();

        AuthMail authMail = new AuthMail(userId, email);
        authMailDao.createAuthMail(authMail);
        sendMail(authMail);
        return authMailDao.selectAuthMail(authMail.getUserId(), authMail.getEmail());
    }

    @Transactional
    public AuthMail authMail(String userId, String email, String code) {
        AuthMail authMail = authMailDao.selectAuthMailByCode(userId, email, code);
        if (authMail != null) {
            authedAccountDao.insertAuthedAccount(
                    new AuthedAccount(authMail.getUserId(), authMail.getEmail())
            );
            authMailDao.deleteAuthMail(
                    userId, email
            );
        }
        return authMail;
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
