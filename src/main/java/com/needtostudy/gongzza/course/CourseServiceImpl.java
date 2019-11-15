package com.needtostudy.gongzza.course;

import com.needtostudy.gongzza.daos.CourseDao;
import com.needtostudy.gongzza.vos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Transactional
    public Course insertCourse(Course course) {
        courseDao.insertCourse(course);
        return courseDao.selectCourseById(course.getId());
    }

    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
    }

    public List<Course> selectCourseListByUserId(String userId) {
        return courseDao.selectCourseListByUserId(userId);
    }
}
