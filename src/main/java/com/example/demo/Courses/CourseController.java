package com.example.demo.Courses;

import com.example.demo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> returnCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId," ", " "));
        courseService.addCourse(course) ;

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id,@PathVariable String topicId) {
        course.setTopic(new Topic(topicId," ", " "));
        courseService.updateCourse(course) ;
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/course/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);  ;
        return  ;

    }
}
