package com.alzohareshopee.webservice.controller;

import java.util.List;
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

import com.alzohareshopee.webservice.entity.Order;
import com.alzohareshopee.webservice.repository.OrderRepository;

@RestController
@RequestMapping("api")
public class OrderController {

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("/order")
	public List<Order> getOrderByName(@RequestParam("name") String name) {
		return orderRepo.findByName(name);
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@GetMapping("/order/{id}")
	public Order getOrderById(@PathVariable("id") long id) {
		return orderRepo.getById(id);
	}

	@PostMapping("/order")
	public Order addOrder(@Valid @RequestBody Order order) {
		return orderRepo.save(order);
	}

	@PutMapping("/orders")
	public Order updateOrder(@Valid @RequestBody Order order) {
		return orderRepo.save(order);
	}

	@DeleteMapping("/order/{id}")
	public String deleteOrder(@Valid @PathVariable("id") long id) {
		orderRepo.deleteById(id);
		return "Order is deleted Successfully";
	}
}
