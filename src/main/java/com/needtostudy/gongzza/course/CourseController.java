package com.needtostudy.gongzza.course;

import com.needtostudy.gongzza.dtos.CourseDto;
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
    public CourseDto insertCourse(@RequestBody CourseDto courseDto) throws Exception {
        return courseService.insertCourse(courseDto);
    }

    @PutMapping("{id}")
    public boolean updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        courseService.updateCourse(course);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return true;
    }

    @GetMapping()
    public List<CourseDto> selectCourseDtoListByUserId(@RequestParam String userId) {
        return courseService.selectCourseDtoListByUserId(userId);
    }
}
