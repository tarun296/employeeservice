package com.example.EmployeeManagementSystem.dto;

public class AuthResponse {
	
	private String token;
	
	public AuthResponse(String token) {
		this.token = token;
	}	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
// This class represents the response sent back to the client after a successful authentication.
