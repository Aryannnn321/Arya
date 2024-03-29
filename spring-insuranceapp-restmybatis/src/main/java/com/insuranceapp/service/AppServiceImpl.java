package com.insuranceapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppServiceImpl {
	@Autowired
	private IAppUserRepository appUserRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		AppUser appUser = appUserRepository.findByUsername(username);
		if(appUser==null) {
			System.out.println("er------------");
			throw new UsernameNotFoundException("username not found");
		}
		String uname = appUser.getUsername();
		String password = appUser.getPassword();
		List<GrantedAuthority>  authorities = appUser.getRoles()
							.stream()
							.map(role->new SimpleGrantedAuthority(role))
							.collect(Collectors.toList());
		// create a User object
		UserDetails userDetails = new User(uname, password, authorities);
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		AppUser appUser = convertToAppUser(user);
		System.out.println(appUser);
		appUserRepository.insert(appUser);
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public AppUser convertToAppUser(UserDetails user) {
		// get data from UserDetails
		String username = user.getUsername();
		String password = user.getPassword();
		List<String>  roles = user.getAuthorities()
							.stream()
							.map(grantedAuthority->grantedAuthority.getAuthority())
							.toList();
		// create appUser object
		AppUser appUser = new AppUser();
		appUser.setUsername(username);
		appUser.setPassword(password);
		appUser.setRoles(roles);
		return appUser;
		
	}
}
