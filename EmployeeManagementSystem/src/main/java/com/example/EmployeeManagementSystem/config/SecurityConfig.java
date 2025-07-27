package com.example.EmployeeManagementSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		    .csrf(customizer -> customizer.disable())
		    .authorizeHttpRequests(auth -> auth
		        .requestMatchers("/api/employees/*").hasRole("ADMIN")
		        .requestMatchers("/api/profile").hasAnyRole("ADMIN", "USER")
		        .requestMatchers("/api/login").permitAll()
		        .anyRequest().authenticated()
		     )
		    .httpBasic(Customizer.withDefaults())
		    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	    
		 return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user = User
				.withDefaultPasswordEncoder()
				.username("user")
				.password("user123")
				.roles("USER")
				.build();
		
		UserDetails admin = User
				.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin123")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	

}
