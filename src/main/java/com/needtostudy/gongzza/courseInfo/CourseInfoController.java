package com.needtostudy.gongzza.courseInfo;

import com.needtostudy.gongzza.vos.CourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courseInfos")
public class CourseInfoController {

    @Autowired
    private CourseInfoService courseInfoService;

    @PostMapping("")
    public CourseInfo insertCourseInfo(@RequestBody CourseInfo courseInfo) {
        return courseInfoService.insertCourseInfo(courseInfo);
    }

    @PutMapping("{id}")
    public int updateCourseInfo(@PathVariable int id, @RequestBody CourseInfo courseInfo) {
        courseInfo.setId(id);
        courseInfoService.updateCourseInfo(courseInfo);
        return 200;
    }

    @DeleteMapping("{id}")
    public int deleteCourseInfo(@PathVariable int id) {
        courseInfoService.deleteCourseInfo(id);
        return 200;
    }
}
