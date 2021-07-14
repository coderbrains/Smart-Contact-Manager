package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.entity.User;
import com.smart.repo.UserRepo;

@Controller
public class HomeController {
	
	@Autowired
	UserRepo userRepo;

	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("title", "Home | smartcontact manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "about-smartcontactmanager");
		return "about";
	}
	
	
	
}
