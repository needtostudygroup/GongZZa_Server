package com.needtostudy.gongzza.course;

import com.needtostudy.gongzza.vos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("")
    public Course insertCourse(@RequestBody Course course) {
        return courseService.insertCourse(course);
    }

    @PutMapping("{id}")
    public int updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        courseService.updateCourse(course);
        return 200;
    }

    @DeleteMapping("{id}")
    public int deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return 200;
    }

    @GetMapping("users/{userId}")
    public List<Course> selectCourseListByUserId(@PathVariable String userId) {
        return courseService.selectCourseListByUserId(userId);
    }
}
