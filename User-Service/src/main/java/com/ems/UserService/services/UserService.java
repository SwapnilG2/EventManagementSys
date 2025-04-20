package com.ems.UserService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.UserService.entities.User;
import com.ems.UserService.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Here we can later add password encryption & validation
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
