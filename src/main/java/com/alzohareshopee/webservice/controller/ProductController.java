package com.alzohareshopee.webservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alzohareshopee.webservice.Exception.ProductNotFound;
import com.alzohareshopee.webservice.entity.Product;
import com.alzohareshopee.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@GetMapping("/product")
	public Optional<Product> getPrdouctByName(@Valid @RequestParam("name") String name) {
		Optional<Product> product = productRepo.getProductByName(name);
		if (product != null) {
			return product;
		}
		throw new ProductNotFound("Product Not Found with given name = " + name);
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> list = productRepo.findAll();
		if (list != null) {
			return list;
		}

		throw new ProductNotFound("Product list is Empty, zero records found.");
	}

	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> product = productRepo.findById(id);
		if (product != null) {
			return product;
		}
		throw new ProductNotFound("Product Not found with given id = " + id);

	}

	@PostMapping("/product")
	public Product addProduct(@Valid @RequestBody Product product) {
		return productRepo.save(product);
	}

	@PutMapping("/products")
	public Map<String, String> updateProduct(@Valid @RequestBody Product product) {
		Product rowsAffected = productRepo.save(product);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Product Updated successfully !");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@Valid @PathVariable("id") long id) {
		productRepo.deleteById(id);
		return "Product Is Deleted Successfully";
	}

}
