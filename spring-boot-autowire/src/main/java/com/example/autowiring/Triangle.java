package com.example.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {

	@Override
	public void area(int x, int y) {
		
		System.out.println("triangle area"+(x+y/2));
	}

}
