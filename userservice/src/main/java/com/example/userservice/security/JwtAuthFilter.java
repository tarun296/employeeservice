package com.example.userservice.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{
	
	   @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private UserDetailsService userDetailsService;

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	            throws ServletException, IOException {

	        final String authHeader = request.getHeader("Authorization");

	        String username = null;
	        String jwtToken = null;

	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	            jwtToken = authHeader.substring(7);
	            username = jwtUtil.extractUsername(jwtToken);
	        }

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            var userDetails = userDetailsService.loadUserByUsername(username);
	            if (jwtUtil.validateToken(jwtToken)) {
	                var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
	        }

	        filterChain.doFilter(request, response);
	    }

}
