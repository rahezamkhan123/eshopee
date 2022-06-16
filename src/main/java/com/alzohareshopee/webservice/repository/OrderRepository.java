package com.alzohareshopee.webservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.alzohareshopee.webservice.entity.Order;

@Repository
@EnableJpaRepositories
@EntityScan
public interface OrderRepository extends JpaRepository<Order, Long> {

//	Optional<Order> getOrderByName(String name);

	@Query(value = "select * from eshopee_order o where o.name like %:name%", nativeQuery = true)
	List<Order> findByName(String name);
}
