package com.example.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	private EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
	}


}
