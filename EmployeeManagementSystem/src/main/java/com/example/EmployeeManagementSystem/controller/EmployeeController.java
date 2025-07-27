package com.example.EmployeeManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	private List<Employee> employees = new ArrayList<>(List.of(
			new Employee(1, "Tharun", "IT", 50000 ),
			new Employee(2, "Ravi", "IT", 60000 )
			));
	
	@GetMapping("/employees")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Employee> getAll() {
		return employees;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		}
	
	@PostMapping("/employees")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee addEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteEmployee(@PathVariable("id") int id) {
		employees.remove(id);
	}
	
}



