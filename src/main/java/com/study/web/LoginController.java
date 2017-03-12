package com.study.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login")
	public String loginPage() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login() {
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String joinPage() {
		return "/user/join";
	}
	
	@PostMapping("/join")
	public String join() {
		return "redirect:/";
	}
}
