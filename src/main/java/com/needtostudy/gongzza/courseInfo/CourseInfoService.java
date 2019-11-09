package com.needtostudy.gongzza.courseInfo;

import com.needtostudy.gongzza.daos.CourseInfoDao;
import com.needtostudy.gongzza.vos.CourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseInfoService implements CourseInfoRepository {

    @Autowired
    private CourseInfoDao courseInfoDao;

    public CourseInfo insertCourseInfo(CourseInfo courseInfo) {
        courseInfoDao.insertCourseInfo(courseInfo);
        return courseInfoDao.selectCourseInfoById(courseInfo.getId());
    }

    public void updateCourseInfo(CourseInfo courseInfo) {
        courseInfoDao.updateCourseInfo(courseInfo);
    }

    public void deleteCourseInfo(int id) {
        courseInfoDao.deleteCourseInfo(id);
    }
}
