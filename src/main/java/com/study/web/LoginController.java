package com.study.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.Utils.HttpSessionUtils;
import com.study.domain.User;
import com.study.domain.UserRepository;

@Controller
@RequestMapping("/user")
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/login")
	public String loginPage() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession httpSession) {
		log.debug("-----User : " + userId);
		
		try{
			if(userId.equals(null) || password.equals(null)) {
				log.error("-----null value Exists");
				return "redirect:/";
			}
			
			User getUser = userRepository.findByUserId(userId);
			if(getUser == null)
				return "/exception/defaulterrorinfo";
			
			if(!getUser.isMatchPassword(password))
				return "redirect:/";
			
			httpSession.setAttribute(HttpSessionUtils.USER_SESSION_KEY, getUser);
		} catch (Exception e) {
			return "/exception/defaulterrorinfo";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String joinPage() {
		return "/user/join";
	}
	
	@PostMapping("/join")
	public String join(User user, HttpSession httpSession) {
		
		try{
			userRepository.save(user);
		} catch (Exception e) {
			
		}
		return "redirect:/";
	}
}
