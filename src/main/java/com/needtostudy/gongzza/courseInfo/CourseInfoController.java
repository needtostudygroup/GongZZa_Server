package com.needtostudy.gongzza.courseInfo;

import com.needtostudy.gongzza.vos.CourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courseInfos")
public class CourseInfoController {

    @Autowired
    private CourseInfoService courseInfoService;

    @PostMapping("courses/{courseId}")
    public CourseInfo insertCourseInfo(@PathVariable int courseId, @RequestBody CourseInfo courseInfo) {
        courseInfo.setCourseId(courseId);
        return courseInfoService.insertCourseInfo(courseInfo);
    }

    @PutMapping("{id}")
    public boolean updateCourseInfo(@PathVariable int id, @RequestBody CourseInfo courseInfo) {
        courseInfo.setId(id);
        courseInfoService.updateCourseInfo(courseInfo);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean deleteCourseInfo(@PathVariable int id) {
        courseInfoService.deleteCourseInfo(id);
        return true;
    }
}
