package com.needtostudy.gongzza.vos;

public class Course {
    private int id;
    private String userId;
    private String name;
    private String professor;

    public Course() {
    }

    public Course(String userId, String name, String professor) {
        this.userId = userId;
        this.name = name;
        this.professor = professor;
    }

    public Course(int id, String userId, String name, String professor) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
