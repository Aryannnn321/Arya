package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {
	@Bean
	public UserDetailsManager userDetailsManager() {
		UserDetails user1=
				User.withUsername("Sri")
							.password(encoder().encode("sri123"))
							.roles("ADMIN", "USER")
							.build();
		UserDetails user2 =User.withUsername("priya")
								.password(encoder().encode("priya123"))
								.roles("USER")
								.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/user/**").hasAnyRole("USER","ADMIN")
				.requestMatchers("/api/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				)
	.sessionManagement(sess -> sess.sessionCreationPolicy(
			SessionCreationPolicy.STATELESS))
	.httpBasic(Customizer.withDefaults())
	.build();
	
	}
}
