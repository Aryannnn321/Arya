package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	@RequestMapping("/greet")
	public String greetUser(Model model) {
		model.addAttribute("message", "great day");
		return "success";
	}
	@RequestMapping("/hello")
	public String sayHello(ModelMap model) {
		model.addAttribute("message", "hello!! have a good day");
		return "success";
	}
	@RequestMapping("/welcome")
	public ModelAndView welcomeUser() {
		ModelAndView modelAndView=new ModelAndView("success", "message", "welcome to mvc");
		return modelAndView;
	}
}
