package com.alzohareshopee.webservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alzohareshopee.webservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> getCustomerByName(String name);
}
