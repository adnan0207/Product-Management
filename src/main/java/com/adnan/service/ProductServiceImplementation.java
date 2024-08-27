package com.adnan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adnan.entity.Product;
import com.adnan.repository.ProductRepo;

@Service
public class ProductServiceImplementation implements ProductService {

	// we write business logic and database operations here

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product createProduct(Product product) {

		Product prod = productRepo.save(product);
		return prod;
	}

	@Override
	public Product findProduct(int productId) {

		Optional<Product> prodOptional = productRepo.findById(productId);
		Product prod = prodOptional.get();
		return prod;
	}

	@Override
	public boolean updateProduct(int productId, Product product) {

		Optional<Product> prodOptional = productRepo.findById(productId);

		if (prodOptional.isPresent()) {
			Product dBProd = prodOptional.get();

			if (product.getName() != null) {
				dBProd.setName(product.getName());
			}

			if (product.getDescription() != null) {
				dBProd.setDescription(product.getDescription());
			}

			if (product.getPrice() != 0) {
				dBProd.setPrice(product.getPrice());
			}
			
			productRepo.save(dBProd);

			return true;
		}

		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {

		productRepo.deleteById(productId);
		return true;
	}

}
