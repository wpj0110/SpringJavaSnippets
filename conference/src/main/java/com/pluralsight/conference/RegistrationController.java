package com.pluralsight.conference;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
	
	@GetMapping("registration")
	public String getRegistration(Map<String,Object> model) {
		return "registration";
	}

}
