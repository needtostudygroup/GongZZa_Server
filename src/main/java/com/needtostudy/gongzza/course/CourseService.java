package com.needtostudy.gongzza.course;

import com.needtostudy.gongzza.dtos.CourseDto;
import com.needtostudy.gongzza.vos.Course;

import java.util.List;

public interface CourseService {

    CourseDto insertCourse(CourseDto courseDto) throws Exception;

    void updateCourse(Course course);

    void deleteCourse(int id);

    List<CourseDto> selectCourseDtoListByUserId(String userId);
}
