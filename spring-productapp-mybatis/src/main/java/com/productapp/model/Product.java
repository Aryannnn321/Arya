package com.productapp.model;

public class Product {
private int prouctId;
private String productName;
private String brand;
private double price;
private String category;
public Product() {
	super();
}
public Product(int prouctId, String productName, String brand, double price, String category) {
	super();
	this.prouctId = prouctId;
	this.productName = productName;
	this.brand = brand;
	this.price = price;
	this.category = category;
}
public int getProuctId() {
	return prouctId;
}
public void setProuctId(int prouctId) {
	this.prouctId = prouctId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

}
