package com.example.javabased;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Waiter {
	
@Autowired
//@Qualifier("getIndian")
private IFoodMenu iFoodMenu;

@Autowired
IFoodMenu menus;
IFoodMenu menuItems;

public void setMenu( IFoodMenu menuItems) {

	this.menuItems =menuItems;
}
public List<String> viewMenuCard(String choice){
	List<String>menuList=new ArrayList<>();
	if("indian".equals(choice)) {
		return iFoodMenu.showMenus();
	}
	else {
		System.out.println("invalid");
	}
	return null;
}
}
