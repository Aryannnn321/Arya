package com.example.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
	@Bean
	public Chinese getChinese() {
		return new Chinese();
	}
	@Bean
	@Primary
	public Italian getItalian() {
		return new Italian();
}
	@Bean
	public Indian geIndian() {
		return new Indian();
}
	@Bean
	public Waiter getWaiter() {
		Waiter waiter =new Waiter();
		waiter.setMenu(getChinese());
		return waiter;
	}
}
