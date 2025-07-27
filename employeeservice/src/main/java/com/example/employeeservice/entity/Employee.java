package com.example.employeeservice.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * employee entity 
 */
public class Employee {
	
	private int id;
	
	@NotBlank
	private String name;
	
	private String department;
	
	private String position;
	
	@Min(0)
	private double salary;
	
	// getters and Setters method
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
