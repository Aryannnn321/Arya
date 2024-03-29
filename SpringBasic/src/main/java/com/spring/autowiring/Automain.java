package com.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Automain {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.autowiring");
	ShapeFactory shapeFactory = (ShapeFactory) context.getBean("shapeFactory");
shapeFactory.printArea("r",10,20);
shapeFactory.printArea("t",10,20);
shapeFactory.printArea("s",10,20);

	}

}
