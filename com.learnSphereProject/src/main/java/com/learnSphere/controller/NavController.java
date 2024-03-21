package com.learnSphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/addCourse")
	public String addCourse() {
		return "addCourse";
	}
	
	@GetMapping("/addLesson")
	public String addLesson()
	{
		return "addLesson";
	}
	@GetMapping("/studentHome")
	public String studentHome()
	{
		return "studentHome";
	}
	
}
