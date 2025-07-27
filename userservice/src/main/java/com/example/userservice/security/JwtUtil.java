package com.example.userservice.security;

import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	    private final SecretKey secretKey = Keys.hmacShaKeyFor("MySuperSecretKeyForJwt1234567890!!".getBytes());
	    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

	    public String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .signWith(secretKey, SignatureAlgorithm.HS256)
	                .compact();
	    }

	    public String extractUsername(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(secretKey)
	                .build()
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
	    }

	    public boolean validateToken(String token) {
	        try {
	            Jwts.parserBuilder()
	                    .setSigningKey(secretKey)
	                    .build()
	                    .parseClaimsJws(token);
	            return true;
	        } catch (JwtException e) {
	            return false;
	        }
	    }

}
