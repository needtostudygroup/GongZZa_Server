package com.needtostudy.gongzza.course;

import com.needtostudy.gongzza.vos.Course;

import java.util.List;

public interface CourseRepository {

    Course insertCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int id);

    List<Course> selectCourseListByUserId(String userId);
}
