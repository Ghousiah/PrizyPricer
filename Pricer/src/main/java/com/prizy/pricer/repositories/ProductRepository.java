package com.prizy.pricer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prizy.pricer.models.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
