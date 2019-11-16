package com.needtostudy.gongzza.vos;

import com.google.api.client.util.Base64;

import java.security.MessageDigest;

public class AuthedAccount {

    private String userId;
    private String email;

    public AuthedAccount() {
    }

    public AuthedAccount(String userId, String email) {
        this.userId = userId;
        this.email = email;
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
}
