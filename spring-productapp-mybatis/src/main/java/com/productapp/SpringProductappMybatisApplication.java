package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappMybatisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappMybatisApplication.class, args);
	}
	@Autowired
	IProductService iProductService;
	@Override
	public void run(String... args) throws Exception {
		Product product=new  Product(4,"rcb", "karnataka",345,"sports");
		iProductService.addProduct(product);
	}
	
	

}
