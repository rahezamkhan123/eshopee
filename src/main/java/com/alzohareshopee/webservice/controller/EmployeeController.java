package com.alzohareshopee.webservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.alzohareshopee.webservice.Exception.EmployeeNotFound;
import com.alzohareshopee.webservice.entity.Employee;
import com.alzohareshopee.webservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
@Validated
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;

	@GetMapping("/employee")
	public List<Employee> getEmployeeByName(@RequestParam("name") String name) {
		List<Employee> list = employeeRepo.findByName(name);
		if (list != null) {
			return list;
		}
		throw new EmployeeNotFound("Employee not found with given  name = " + name);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> list = employeeRepo.findAll();
		if (list != null) {
			return list;
		}
		throw new EmployeeNotFound("Employee list is empty !, Zero records Found");
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		Employee employee = employeeRepo.getById(id);
		if (employee != null) {
			return employee;
		}
		throw new EmployeeNotFound("Employee Not found with given id = " + id);
	}

	@PostMapping("/employee")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}

	@PutMapping("/employees")
	public Map<String, String> updateEmployee(@Valid @RequestBody Employee employee) {
		Employee rowsAffected = employeeRepo.save(employee);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Employee updated successfully !");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@Valid @PathVariable("id") long id) {
		employeeRepo.deleteById(id);
		return "Employee Deleted Successfully -----------";
	}
}
