package com.needtostudy.gongzza.course;

import com.needtostudy.gongzza.daos.CourseDao;
import com.needtostudy.gongzza.daos.CourseInfoDao;
import com.needtostudy.gongzza.dtos.CourseDto;
import com.needtostudy.gongzza.vos.Course;
import com.needtostudy.gongzza.vos.CourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseInfoDao courseInfoDao;

    @Transactional
    public CourseDto insertCourse(CourseDto courseDto) throws Exception {
        if (courseDto.getCourseInfoList() == null || courseDto.getCourseInfoList().size() == 0)
            throw new Exception();

        courseDao.insertCourse(courseDto);
        for (CourseInfo info : courseDto.getCourseInfoList()) {
            info.setCourseId(courseDto.getId());
            courseInfoDao.insertCourseInfo(info);
        }
        return courseDao.selectCourseDtoById(courseDto.getId());
    }

    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
    }

    public List<CourseDto> selectCourseDtoListByUserId(String userId) {
        return courseDao.selectCourseDtoListByUserId(userId);
    }
}
