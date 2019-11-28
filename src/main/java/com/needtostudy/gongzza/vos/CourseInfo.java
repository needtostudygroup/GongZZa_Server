package com.needtostudy.gongzza.vos;

import java.util.Date;

public class CourseInfo {
    private int id;
    private int courseId;
    private Date startTime;
    private Date endTime;
    private int day;

    public CourseInfo() {
    }
    public CourseInfo(int id, int courseId, Date startTime, Date endTime, int day) {
        this.id = id;
        this.courseId = courseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }
    public CourseInfo(int courseId, Date startTime, Date endTime, int day) {
        this.courseId = courseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public CourseInfo(Date startTime, Date endTime, int day) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
