package com.voya.dist.SpringAssignments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
private int capacity;
private String type;
public int getCapacity() {
	return capacity;
}
@Value("100")
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public String getType() {
	return type;
}
@Value("diesel")
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "Engine [capacity=" + capacity + ", type=" + type + "]";
}

}
