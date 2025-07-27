package com.example.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.security.JwtUtil;

@RestController
@RequestMapping
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	/**
	 * Endpoint to login and generate JWT token.
	 * @param username the username of the user
	 * @return ResponseEntity containing the JWT token
	 */
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username){
		String token = jwtUtil.generateToken(username);
		return ResponseEntity.ok(token);
	}

}
