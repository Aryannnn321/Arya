package com.insuranceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceapp.model.AppUser;
import com.insuranceapp.model.AppUserMapper;
import com.insuranceapp.util.JwtTokenUtil;

@RestController
@RequestMapping("/user-api/v1")
public class AppUserController {
	@Autowired
	private AppUserServiceImpl userServiceImpl;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired 
	private PasswordEncoder encoder;
	@Autowired
    JwtTokenUtil tokenUtil;
	
	@Autowired
	
	private UserDetailsManager appUserServiceImpl;
	@PostMapping("/register")
ResponseEntity<Void> createUser(@RequestBody AppUser appUser) {
		UserDetails details =AppUserMapper.convertToUserDetails(appUser);
		appUserServiceImpl.createUser(details);
		return ResponseEntity.status(HttpStatus.CREATED.value()).build();
}
	@PostMapping("/authenticate")
	ResponseEntity<String> authenticateUser(@RequestBody AppUser appUser)  {
		UserDetails details =AppUserMapper.convertToUserDetails(appUser);
		AppUser user=appUserServiceImpl.loadUserByUsername(appUser.getUserName());
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(null);
}
}
