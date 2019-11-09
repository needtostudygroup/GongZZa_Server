package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.CourseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseInfoDao {

    void insertCourseInfo(CourseInfo courseInfo);

    void updateCourseInfo(CourseInfo courseInfo);

    void deleteCourseInfo(int id);

    CourseInfo selectCourseInfoById(int id);

    List<CourseInfo> selectCourseInfoListByCourseId(int courseId);
}
