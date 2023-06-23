package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.service.StoreService;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signin")
	public String getSigninPage(){
		return "signin";
	}
	
	
	@GetMapping("/signup")
	public String getSignupPage(Model model) {
		// model.addAttribute("errMsg", "User account exists!");
		return "signup";
	}
	

	@PostMapping("/process_signup")
	public String processSignup(@ModelAttribute("user") User user, 
			RedirectAttributes redirectAttributes) {

		// check if user exist
		if (userService.findByEmail(user.getEmail()) != null){
			redirectAttributes.addFlashAttribute("errMsg", "User account exists!" + 
			"Wanna login? <a href='/signin'>Sign in here</a>");
			return "redirect:signup";
		}
		// if not  exist, create user
		else{
			userService.saveNewUser(user);
			//redirect to signin page
			return "redirect:signin";
		}

	}
	
	

}
