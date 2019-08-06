package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/funny")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-world-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		String uppercaseName = theName.toUpperCase();
		String result = "Yo! " + uppercaseName;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		String uppercaseName = theName.toUpperCase();
		String result = "Yo! " + uppercaseName;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	
}