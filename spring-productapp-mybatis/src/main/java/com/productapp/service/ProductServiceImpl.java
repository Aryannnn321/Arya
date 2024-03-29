package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl  implements IProductService{
@Autowired
private IProductRepository iProductRepository;
	@Override
	public void addProduct(Product product) {
	iProductRepository.addProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
	iProductRepository.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
	iProductRepository.deleteProduct(product);
	}

	@Override
	public Product getById(int productId) {
		Product product=iProductRepository.findById(productId);
		if(product==null) 
			throw new ProductNotFoundException();
			return product;	
		}
		
	

	@Override
	public List<Product> getAll() {
		List<Product> productList=iProductRepository.findAll();
		return productList;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> productList=iProductRepository.findByBrand(brand);
		return productList;
	}

	@Override
	public List<Product> getByLessPrice(double price) {
		List<Product> productList=iProductRepository.findByLessPrice(price);
		return productList;
	}

	@Override
	public List<Product> getByCategoryAndPrice(String category, double price) {
		List<Product> productList=iProductRepository.findByCategoryAndPrice(category,price);
		return productList;
	}

}
