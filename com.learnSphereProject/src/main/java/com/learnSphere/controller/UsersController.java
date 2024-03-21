package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Users;
import com.learnSphere.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UsersService uservice;
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute Users user, Model model) {
		String email=user.getEmail();
		boolean isPresent=uservice.checkEmail(email);
		
		if(isPresent==false) {
		uservice.addUser(user);
		return "login";
		}
		else {
			model.addAttribute("errorMessage", "Email already exists");
	        return "register";
		}
	}
	
	@PostMapping("/validateUser")
	public String validateUser(@RequestParam( "email") String email,
			@RequestParam("password") String password,HttpSession session, Model model)
			{
		
		Users user=uservice.findUserByEmail(email);
		String dbPassword=user.getPassword();
		String role=user.getRole();
		
		if(password.equals(dbPassword)) {
			session.setAttribute("loggedInUser", user);
			model.addAttribute("user", user);
			
			if(role.equals("trainer")) {
				return "trainerHome";
			}
			else {
				return"studentHome";
			}
			
		}
		else {
			String errorMessage = "Invalid username or password";
			model.addAttribute("errorMessage", errorMessage);
			return "login";
		}
		
		 
	}
	
	

}