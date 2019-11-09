package com.needtostudy.gongzza.vos;

public class Token {

    private String id;
    private String token;
    private int serviceId;

    public Token() {

    }

    public Token(String id, String token, int serviceId) {
        this.id = id;
        this.token = token;
        this.serviceId = serviceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
