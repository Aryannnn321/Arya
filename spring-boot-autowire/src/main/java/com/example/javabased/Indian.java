package com.example.javabased;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

public class Indian implements IFoodMenu {

	@Override
	public List<String> showMenus() {
		
		return Arrays.asList("roti", "mudde","nati koli saru");
	}

}
