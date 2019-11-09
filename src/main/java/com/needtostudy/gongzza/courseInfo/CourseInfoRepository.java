package com.needtostudy.gongzza.courseInfo;

import com.needtostudy.gongzza.vos.CourseInfo;

public interface CourseInfoRepository {

    CourseInfo insertCourseInfo(CourseInfo courseInfo);

    void updateCourseInfo(CourseInfo courseInfo);

    void deleteCourseInfo(int id);
}
