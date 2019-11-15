package com.needtostudy.gongzza.vos;

public class CourseInfo {
    private int id;
    private int courseId;
    private String startTime;
    private String endTime;
    private int day;

    public CourseInfo() {
    }
    public CourseInfo(int id, int courseId, String startTime, String endTime, int day) {
        this.id = id;
        this.courseId = courseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }
    public CourseInfo(int courseId, String startTime, String endTime, int day) {
        this.courseId = courseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public CourseInfo(String startTime, String endTime, int day) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
