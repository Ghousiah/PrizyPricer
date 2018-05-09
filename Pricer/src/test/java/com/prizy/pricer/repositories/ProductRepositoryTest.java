package com.prizy.pricer.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.pricer.models.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { RepositoryConfiguration.class })
public class ProductRepositoryTest {

	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Test
	public void testSaveProduct() {
		// setup product
		double price = 350.564;
		Product product = new Product();
		product.setBarcode("5af211ba124f9c31784bcbdb");
		product.setName("Samsung");
		product.setPrice(price);
		product.setDescription("Smart Phone");
		product.setAvgPrice(price);
		product.setHighestPrice(price);
		product.setLowestPrice(price);
		product.setIdealPrice(price);
		product.setPriceCollectCount(1);

		// verify id value after save
		assertNull(product.getBarcode());
		productRepository.save(product);
		assertNotNull(product.getBarcode());

		// read from mongodb
		Optional<Product> fetchedProduct = productRepository.findById(product.getBarcode());

		// check if null or not
		assertNotNull(fetchedProduct);

		// equality check
		assertEquals(product.getBarcode(), fetchedProduct.get().getBarcode());
		assertEquals(product.getName(), fetchedProduct.get().getName());

		// check update and save
		fetchedProduct.get().setDescription("New Description");
		productRepository.save(fetchedProduct.get());

		// read data from mongodb and update
		Optional<Product> updateProduct = productRepository.findById(fetchedProduct.get().getBarcode());
		assertEquals(fetchedProduct.get().getDescription(), updateProduct.get().getDescription());

		// verify count of products in database
		long productCount = productRepository.count();
		assertEquals(productCount, 1);

		// get all products list and it should contain only one document
		List<Product> products = productRepository.findAll();

		int count = 0;

		for (Product prod : products) {
			count++;
		}

		assertEquals(count, 1);
	}
}
