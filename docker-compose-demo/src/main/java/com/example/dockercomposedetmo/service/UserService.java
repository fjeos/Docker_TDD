package com.example.dockercomposedetmo.service;

import com.example.dockercomposedetmo.entity.User;
import com.example.dockercomposedetmo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(String username, String email) {
        User newUser = new User(username, email);
        return userRepository.save(newUser);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // 다른 메서드들...
}