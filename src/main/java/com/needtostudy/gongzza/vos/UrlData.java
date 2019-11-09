package com.needtostudy.gongzza.vos;

public class UrlData {

    private int id;
    private String name;
    private String url;
    private int serviceId;
    private int priority;

    public UrlData() {}

    public UrlData(int id, String name, String url, int serviceId, int priority) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.serviceId = serviceId;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
