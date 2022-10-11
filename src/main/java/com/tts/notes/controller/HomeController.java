package com.tts.notes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.notes.entity.UserInfo;
import com.tts.notes.repository.UserRepository;

@Controller
public class HomeController {
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute UserInfo user, Model m, HttpSession session) {
		
		
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
		UserInfo u = userRepo.save(user);

		if (u != null) {
			session.setAttribute("msg", "Register Sucessfully");
		} else {
			session.setAttribute("msg", "Something wrong on server");
		}

		return "redirect:/signup";
	}


}