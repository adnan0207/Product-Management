package com.adnan.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adnan.dto.ProductDTO;
import com.adnan.entity.Product;
import com.adnan.service.ProductService;

@RestController
public class ProductController {

	// calling service layer methods

	@Autowired
	private ProductService productService;

	@Autowired
	private ModelMapper modelMapper;

//	http://127.0.0.1:8086/api/v1/addProduct
	@PostMapping("api/v1/addProduct")
	public ProductDTO createProduct(@RequestBody Product product) {

		Product prod = productService.createProduct(product);
		ProductDTO dtoProduct = modelMapper.map(prod, ProductDTO.class);
		return dtoProduct;

	}

	// using path variable
//	http://127.0.0.1:8086/api/v1/findProduct/2
	@GetMapping("api/v1/findProduct/{productId}")
	public ProductDTO findProductByPathVariable(@PathVariable int productId) {

		Product prod = productService.findProduct(productId);
		ProductDTO dtoProduct = modelMapper.map(prod, ProductDTO.class);
		return dtoProduct;

	}

	// using request parameters
//	http://127.0.0.1:8086/api/v1/findProduct?id=2
	@GetMapping("api/v1/findProduct")
	public ProductDTO findProductByRequestParam(@RequestParam(name="id") int productId) {

		Product prod = productService.findProduct(productId);
		ProductDTO dtoProduct = modelMapper.map(prod, ProductDTO.class);
		return dtoProduct;

	}

	// using request parameters and path variable
	// request param is optional
//	http://127.0.0.1:8086/api/v1/findProduct/1/dual?productName=watchsfdgd
	@GetMapping("api/v1/findProduct/{productId}/dual")
	public ProductDTO findProductByRequestParamAndPathVariable(@RequestParam(name="productName") String name, @PathVariable int productId) {
		
		Product prod = productService.findProduct(productId);
		ProductDTO dtoProduct = modelMapper.map(prod, ProductDTO.class);
		return dtoProduct;
		
	}

//	http://127.0.0.1:8086/api/v1/updateProduct/2
	@PutMapping("api/v1/updateProduct/{productId}")
	public boolean updateProduct(@PathVariable int productId, @RequestBody Product product) {

		boolean isProductUpdated = productService.updateProduct(productId, product);
		return isProductUpdated;		
	}

//	http://127.0.0.1:8086/api/v1/removeProduct/3
	@DeleteMapping("api/v1/removeProduct/{productId}")
	public boolean deleteProduct(@PathVariable int productId) {

		boolean isProductDeleted = productService.deleteProduct(productId);
		return isProductDeleted;
	}

}
