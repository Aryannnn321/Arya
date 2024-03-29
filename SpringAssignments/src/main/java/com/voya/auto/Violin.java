package com.voya.auto;

import org.springframework.stereotype.Component;

@Component
public class Violin implements IInstrument {

	public void play(String song) {
		System.out.println(song+"playing song using violin");
		
	}

}
