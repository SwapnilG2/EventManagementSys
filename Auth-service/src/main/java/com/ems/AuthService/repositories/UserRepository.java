package com.ems.AuthService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.AuthService.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
