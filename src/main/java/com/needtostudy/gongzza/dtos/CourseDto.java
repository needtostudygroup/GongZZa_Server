package com.needtostudy.gongzza.dtos;

import com.needtostudy.gongzza.vos.Course;
import com.needtostudy.gongzza.vos.CourseInfo;

import java.util.List;

public class CourseDto extends Course {

    private List<CourseInfo> courseInfoList;

    public List<CourseInfo> getCourseInfoList() {
        return courseInfoList;
    }

    public void setCourseInfoList(List<CourseInfo> courseInfoList) {
        this.courseInfoList = courseInfoList;
    }
}
