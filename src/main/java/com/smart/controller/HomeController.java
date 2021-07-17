package com.smart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.entity.User;
import com.smart.helper.Message;
import com.smart.repo.UserRepo;
import com.smart.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;

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
			@RequestParam(value="check", defaultValue = "false")boolean check, Model model, HttpSession session) {
		

		
		try {

			if(!check) {
				throw new Exception("You have not checked the terms and conditions");
			}
			
			model.addAttribute("user", user);

			//setting the user default values.
			user.setEnable(true);
			user.setUserRole("ROLE_USER");
			userService.setUser(user);
			session.setAttribute("message", new Message("Successfully registered.", "alert-success"));
			return "signup";
		} catch (Exception e) {
			
			model.addAttribute("user", user);
			e.printStackTrace();
			session.setAttribute("message", new Message("Something went wrong.." + e.getMessage(), "alert-danger"));
			return "signup";			
		}
		
		

	}
	
	
	
}
