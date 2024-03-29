package com.voya.dist.SpringAssignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
private Integer vehicleId;
private String model;
private String brand;
private double price;
private Engine engine;
public Integer getVehicleId() {
	return vehicleId;
}
@Value("121")
public void setVehicleId(Integer vehicleId) {
	this.vehicleId = vehicleId;
}
@Value("2012")
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getBrand() {
	return brand;
}
@Value("Maruthi")
public void setBrand(String brand) {
	this.brand = brand;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
	
}
public Engine getEngine() {
	return engine;
}
@Autowired
public void setEngine(Engine engine) {
	this.engine = engine;
}

@Override
public String toString() {
	return "Vehicle [vehicleId=" + vehicleId + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
}

}
