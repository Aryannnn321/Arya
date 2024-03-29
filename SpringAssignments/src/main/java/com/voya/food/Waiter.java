package com.voya.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Waiter {
	private IFoodMenu indiaMenu;
@Autowired
public Waiter(@Qualifier("indian") IFoodMenu indiaMenu) {
	super();
	this.indiaMenu =indiaMenu;
}
public List<String> viewMenu(String choice){
	if("indian".equals(choice)) {
		return indiaMenu.showMenus();
	}
	else {
		System.out.println("invalid");
	}
	return null;
}
}
