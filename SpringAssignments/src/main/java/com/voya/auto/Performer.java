package com.voya.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Performer {
	private IInstrument instrument;
	
	@Autowired
    
	public Performer(@Qualifier("violin") IInstrument instrument) {
     super();
     this.instrument=instrument;

}
	public void play(String type, String song) {
		if("violin".equals(type)) {
			instrument.play(song);
		}
		else {
			System.out.print("enter valid data");
		}
	}
}
