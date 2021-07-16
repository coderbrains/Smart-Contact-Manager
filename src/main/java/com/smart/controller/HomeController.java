package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.entity.User;
import com.smart.repo.UserRepo;

@Controller
public class HomeController {
	
	@Autowired
	UserRepo userRepo;

	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("title", "Home | smartcontact manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "about-smartcontactmanager");
		return "about";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "register-smartcontactmanager");
		return "signup";
	}
	
	
	@PostMapping("/do_signup")
	public String signuppage(@ModelAttribute("user") User user ,
			@RequestParam(value="check", defaultValue = "false")boolean check, Model model) {
		model.addAttribute("user", user);
		return "signup";
	}
	
	
	
}
