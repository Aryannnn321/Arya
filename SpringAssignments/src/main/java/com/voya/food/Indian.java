package com.voya.food;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component("indian")
public class Indian implements IFoodMenu {

	@Override
	public List<String> showMenus() {
		
		return Arrays.asList("roti", "mudde","nati koli saru");
	}

}
