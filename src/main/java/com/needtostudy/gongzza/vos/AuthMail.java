package com.needtostudy.gongzza.vos;

import com.google.api.client.util.Base64;

import java.security.MessageDigest;

public class AuthMail {

    private String userId;
    private String email;
    private String code;

    public AuthMail() {
    }

    public AuthMail(String userId, String email) throws Exception {
        this.userId = userId;
        this.email = email;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update((userId + email).getBytes());
        this.code = Base64.encodeBase64URLSafeString(digest.digest());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
