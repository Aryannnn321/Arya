package com.voya.food;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Chinese implements IFoodMenu {

	@Override
	public List<String> showMenus() {
	
		return Arrays.asList("panipuri","gobi","nood;es");
	}

}
