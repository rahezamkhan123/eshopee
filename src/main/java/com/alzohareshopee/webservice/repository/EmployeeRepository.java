package com.alzohareshopee.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alzohareshopee.webservice.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "select * from eshopee_empl o where o.name like %:name%", nativeQuery = true)
	List<Employee> findByName(String name);
}
