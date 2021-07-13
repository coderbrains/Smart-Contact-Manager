package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.entity.User;
import com.smart.repo.UserRepo;

@Controller
public class HomeController {
	
	@Autowired
	UserRepo userRepo;

	@GetMapping("/home")
	public String home() {
		
		User user  = new User();
		user.setEmail("awanaih");
		user.setEnable(false);
		userRepo.save(user);
		
		return "home";
	}
	
}
