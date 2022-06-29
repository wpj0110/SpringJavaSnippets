package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@GetMapping("/courses") //localhost:8080/courses/
	public List<Course> getAllCourses() {
		return Arrays.asList(new Course(1, "Learn Microservices", "in28minutes"),
				new Course(2, "Learn Spring", "in28months"));
	}
	
	@GetMapping("/courses/1") //localhost:8080/courses/1
	public List<Course> getCourseOne() {
		return Arrays.asList(new Course(1, "Learn Microservices", "in28minutesBlah"));
	}
}
