package com.insuranceapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class WebConfig {
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new AppUserServiceImpl();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsManager());
		provider.setPasswordEncoder(encoder());
		return provider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	// authorization
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		    .exceptionHandling(ex -> ex.authenticationEntryPoint(authenticationEntryPoint))
//		    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(httpRequest -> {
					// no need to authenticate and authorize
					httpRequest.requestMatchers("/user-api/v1/register", "/user-api/v1/authenticate").permitAll()
							// authorize users with role as user or admin
							.requestMatchers("/insurance-api/v1/user/**").hasAnyAuthority("USER", "ADMIN")
							// authorize users with role as admin
							.requestMatchers("/insurance-api/v1/admin/**").hasAuthority("ADMIN")

							.anyRequest().authenticated();
				});
		http.authenticationProvider(daoAuthenticationProvider());
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();

	}
}
