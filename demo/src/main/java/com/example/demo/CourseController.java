package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
	
	@GetMapping("/courses")
	public void doNothing() { //check courses.html
		
	}
}
