package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("product-api/v1")
public class ProductController {
	@Autowired
	IProductService iProductService;
	
	@PostMapping("/products")
	
	void addProduct(@RequestBody Product product) {
		iProductService.addProduct(product);
	}
	@PutMapping("/products")
	void updateProduct(@RequestBody Product product) {
	iProductService.updateProduct(product);	
	}
	@DeleteMapping("/products/product-id/{productId}")
	void deleteProduct(@PathVariable ("productId")Product productId) {
		iProductService.deleteProduct(productId);
	}
	@GetMapping("/products/product-id/{productId}")
	Product getById(@PathVariable("product") int productId){
		return iProductService.getById(productId);
	}
	@GetMapping("/products")
	List<Product> getAll(){
		return iProductService.getAll();
	}
	@GetMapping("/products/brand/{brand}")
	List<Product> getByBrand(@PathVariable ("brand") String brand) {
		return iProductService.getByBrand(brand);
	}
	@GetMapping("/products/type-price")
	List<Product> getByLessPrice(@RequestParam ("price")double price) {
		return iProductService.getByLessPrice(price);
	}
	@GetMapping("/products/category/{category}/price/{price}")
	List<Product> getByCategoryAndPrice(@RequestParam ("category")String category,@RequestParam("price") double price){
		return iProductService.getByCategoryAndPrice(category, price);
	}
}
