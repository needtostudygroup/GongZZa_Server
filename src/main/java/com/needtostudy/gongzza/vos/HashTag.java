package com.needtostudy.gongzza.vos;

public class HashTag {

    private int id;
    private int postId;
    private String title;
    private String color;

    public HashTag() {
    }

    public HashTag(int id, int postId, String title, String color) {
        this.id = id;
        this.postId = postId;
        this.title = title;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
