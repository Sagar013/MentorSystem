package com.mentorsys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mentorsys.dao.UserRepository;
import com.mentorsys.entities.User;
import com.mentorsys.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title","Home - UPES");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About - UPES");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","Register - UPES");
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@GetMapping("/signin")
	public String customLogin(Model model) {
		model.addAttribute("title","Login - UPES");
		return "login";
	}
	//Handler for registering user
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User result = this.userRepository.save(user);
		
		model.addAttribute("user",result);
		session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
		return "signup";
	}
}
