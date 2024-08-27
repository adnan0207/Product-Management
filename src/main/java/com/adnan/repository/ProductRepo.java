package com.adnan.repository;

import org.springframework.data.repository.CrudRepository;

import com.adnan.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{

}
