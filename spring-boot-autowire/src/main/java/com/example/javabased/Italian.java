package com.example.javabased;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

public class Italian implements IFoodMenu {

	@Override
	public List<String> showMenus() {
		
		return Arrays.asList("burger","cockroach");
	}

}
