package com.prizy.pricer.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.pricer.models.Product;
import com.prizy.pricer.services.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// This is used by the administrator to see all available products
	@RequestMapping(value = { "/", "/getlist" }, method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return this.productService.getAllProducts();
	}

	// This is what the workers use to enter prices
	@RequestMapping(value = { "/insert" }, method = RequestMethod.POST)
	public Product insertProduct(@RequestBody Product product) {
		Product response = this.productService.addProduct(product);
		return response;
	}

	// This is used by the administrator find a specific product
	@RequestMapping(value = { "/select/{id}" }, method = RequestMethod.GET)
	public Product getProductById(@PathVariable(name = "id", required = true) String id) {
		Optional<Product> response = this.productService.getProductById(id);
		return response.isPresent() ? response.get() : new Product();
	}

	@RequestMapping(value = { "/delete/{id}" })
	public void deleteProduct(@PathVariable(name = "id") String id) {
		this.productService.deleteProduct(id);
	}

	@RequestMapping(value = { "/update/{id}" }, method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable(value = "id") String id, @RequestBody Product product) {
		Optional<Product> prod = this.productService.getProductById(id);
		Product response = prod.isPresent() ? prod.get() : new Product();

		if (product.getName() != null)
			response.setName(product.getName());
		if (product.getDescription() != null)
			response.setDescription(product.getDescription());
		if (product.getPrice() > 0.0)
			response.setPrice(product.getPrice());
		if (product.getAvgPrice() > 0.0)
			response.setAvgPrice(product.getAvgPrice());
		if (product.getLowestPrice() > 0.0)
			response.setLowestPrice(product.getLowestPrice());
		if (product.getHighestPrice() > 0.0)
			response.setHighestPrice(product.getHighestPrice());
		if (product.getIdealPrice() > 0.0)
			response.setIdealPrice(product.getIdealPrice());
		if (product.getPriceCollectCount() > 0)
			response.setPriceCollectCount(product.getPriceCollectCount());

		return response;
	}
}
