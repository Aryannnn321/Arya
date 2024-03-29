package com.spring.autowiring;

import org.springframework.stereotype.Component;

@Component("shaper")
public class Square implements Shape{

	@Override
	public void area(int x, int y) {
		System.out.println("square area"+(x*x));
		
	}

}
