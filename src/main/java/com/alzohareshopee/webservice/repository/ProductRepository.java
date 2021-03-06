package com.alzohareshopee.webservice.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alzohareshopee.webservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> getProductByName(String name);
}
