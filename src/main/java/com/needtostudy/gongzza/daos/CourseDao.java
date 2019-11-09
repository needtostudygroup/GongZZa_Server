package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {

    void insertCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int id);

    Course selectCourseById(int id);

    List<Course> selectCourseListByUserId(String userId);
}
