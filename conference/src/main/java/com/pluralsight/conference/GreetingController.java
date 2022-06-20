package com.pluralsight.conference;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
	
	@GetMapping("greeting") //tells which method will handle the request
	public String greeting(Map <String, Object> model) {
		model.put("message", "Hello Will");
		return "greeting";
	}

}
