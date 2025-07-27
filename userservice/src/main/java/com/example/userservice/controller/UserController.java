package com.example.userservice.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dto.AuthResponse;
import com.example.userservice.dto.LoginRequest;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public ResponseEntity<?> register (@Valid @RequestBody User user) {
		// Logic to register a user
		return ResponseEntity.ok(userService.register(user));
	}
	
	  @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
	        System.out.println("Login API hit");
	        try {
	            String token = userService.login(request.getUsername(), request.getPassword());
	            return ResponseEntity.ok(new AuthResponse(token));
	        } catch (Exception e) {
	            return ResponseEntity.status(401).body("Login failed: " + e.getMessage());
	        }
	    }

	    // Get users by username
	    @GetMapping("/{username}")
	    public ResponseEntity<User> getUser(@PathVariable String username) {
	        User user = userService.getUserByUsername(username);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    
	    // Get currently authenticated user's profile
	    @GetMapping("/profile")
	    public ResponseEntity<?> profile(Principal principal) {
	        return ResponseEntity.ok(principal.getName());
	    }
	    
	    @GetMapping("/hello")
	    public ResponseEntity<String> hello() {
	        return ResponseEntity.ok("Hello from secured endpoint!");
	    }

}
