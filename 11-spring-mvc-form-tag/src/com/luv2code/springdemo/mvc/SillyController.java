package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/silly")
public class SillyController {
	
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "hello-world-form";
	}
	

	
	
}