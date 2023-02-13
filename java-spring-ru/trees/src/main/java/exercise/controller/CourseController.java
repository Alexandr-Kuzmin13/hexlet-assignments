package exercise.controller;

import com.sun.xml.bind.v2.model.core.ID;
import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "")
    public Iterable<Course> getCorses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // BEGIN
    @GetMapping(path = "/{id}/previous/")
    public Iterable<Course> getCourseList(@PathVariable long id) {
        Course course = courseRepository.findById(id);
        List<Long> ids = Arrays.stream(course.getPath().split("\\."))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        return courseRepository.findAllById(ids);
    }
    // END

}
