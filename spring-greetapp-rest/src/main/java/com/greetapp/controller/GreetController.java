package com.greetapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	@GetMapping("/show")
	public String showMessage() {
		return "Great day";
	}
	@GetMapping("/say-hello/{uname}")
	public String sayHello(@PathVariable("uname")String username) {
		return "Hello"+username;
	}
	@GetMapping("/user-details")
	public String showUserDetails(@RequestParam("name") String username,
			@RequestParam("city") String city) {
		return "Welcome" +username+"from"+city;
	}
	@GetMapping("/show-courses")
	public List<String> showCourses(){
		return Arrays.asList("java","spring","angular");
	}
}
