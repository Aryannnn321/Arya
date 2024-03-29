package com.insuranceapp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

public class AppUserMapper {
	public AppUser convertToAppUser(UserDetailsServiceAutoConfiguration userDetails) {
		String username= userDetails.getUsername();
		String password= userDetails.getPassword();
			AppUser appUser =new AppUser();
			appUser.setUsername(username);
			appUser.setPassword(password);
			return appUser;
	}
	public AppUser convertToUserDetails(AppUserMapper appUser) {
		String username=appUser.getUsername();
		String password=appUser.getPassword();
		List<GrantedAuthority> authorities =new ArrayList<>();
		return appUser;
	}
	private String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}
