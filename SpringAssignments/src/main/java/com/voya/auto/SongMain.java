package com.voya.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.voya.dist.SpringAssignments.Vehicle;
@Component
public class SongMain {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext("com.voya.auto");
	Performer performer =  context.getBean(Performer.class);
	performer.play("violin", "E sal cup namdhu");
}
}
