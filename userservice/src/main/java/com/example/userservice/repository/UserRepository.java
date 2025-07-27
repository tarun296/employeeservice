package com.example.userservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
		Optional<User> findByUsername(String username);
	
	// Additional query methods can be defined here if needed

}
