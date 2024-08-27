package com.adnan.service;

import com.adnan.entity.Product;

public interface ProductService {

	public Product createProduct(Product product);
	public Product findProduct(int productId);
	public boolean updateProduct(int productId, Product product);
	public boolean deleteProduct(int productId);

}