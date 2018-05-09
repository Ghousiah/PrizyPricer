package com.prizy.pricer.services;

import java.util.List;
import java.util.Optional;

import com.prizy.pricer.models.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAllProducts();

	public Optional<Product> getProductById(String id);

	public Product updateProduct(Product product);

	public void deleteProduct(String id);

}
