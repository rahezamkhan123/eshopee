package com.alzohareshopee.webservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alzohareshopee.webservice.Exception.CustomerNotFound;
import com.alzohareshopee.webservice.entity.Customer;
import com.alzohareshopee.webservice.repository.CustomerRepository;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;

	@GetMapping("/customer")
	public Optional<Customer> getCustomerByName(@Valid @RequestParam("name") String name) {
		Optional<Customer> customer = customerRepo.getCustomerByName(name);
		if (customer != null) {
			return customer;
		}
		throw new CustomerNotFound("Customer not found by ginven name = " + name);
	}

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> list = customerRepo.findAll();
		if (list != null) {
			return list;
		}
		throw new CustomerNotFound("Customer list is empty , zero records in customer Table !");
	}

	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") long id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer != null) {
			return customer;
		}
		throw new CustomerNotFound("Customer not found by give id =" + id);
	}

//	@PostMapping("/customer")
//	public Map<String, String> addCustomer(@RequestBody Customer customer) {
//		Customer rowsAffected = customerRepo.save(customer);
//		Map<String, String> response = new HashMap<String, String>();
//		response.put("message", "Customer added successfully !");
//		response.put("rowsAffected", String.valueOf(rowsAffected));
//		return response;
//
//	}

	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerRepo.save(customer);
	}

	@PutMapping("/customers")
	public Map<String, String> updateCustomer(@Valid @RequestBody Customer customer) {
		Customer rowsAffected = customerRepo.save(customer);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Product added successfully !");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@Valid @PathVariable("id") long id) {
		customerRepo.deleteById(id);
		return "Customer Deleted Successfully -----------";
	}
}
