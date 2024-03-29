package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
void addProduct(Product product);
void updateProduct(Product product);
void deleteProduct(Product productId);
Product getById(int productId) throws ProductNotFoundException;
List<Product> getAll();
List<Product> getByBrand(String brand) throws ProductNotFoundException;
List<Product> getByLessPrice(double price) throws ProductNotFoundException;
List<Product> getByCategoryAndPrice(String category, double price)throws ProductNotFoundException;
}
