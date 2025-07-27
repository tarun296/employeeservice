package com.example.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	// Additional query methods can be defined here if needed
	
}
