package com.example.springboot_first_project.service;

import com.example.springboot_first_project.model.User;
import com.example.springboot_first_project.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User userRegister(String username, String password) {
        String cryptedPassword = passwordEncoder.encode(password);
        User user = new User(username, cryptedPassword);
        return userRepository.save(user);
    }

    public Optional<User> searchByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
