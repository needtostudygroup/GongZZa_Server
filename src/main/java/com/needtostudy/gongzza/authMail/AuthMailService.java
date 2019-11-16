package com.needtostudy.gongzza.authMail;

import com.needtostudy.gongzza.vos.AuthMail;

public interface AuthMailService {

    AuthMail createAuthMail(String userId, String email) throws Exception;

    AuthMail selectAuthMailByCode(String userId, String email, String code);

    void deleteAuthMail(String userId, String email);

    void sendMail(AuthMail authMail) throws Exception;
}
