package com.projects.library.service;

import com.projects.library.model.User;
import com.projects.library.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        String hashedPassword = bCryptPasswordEncoder.encode(user.password());
        User newUser = new User(user.id(), user.username(), user.email(), hashedPassword);
        userRepository.save(newUser);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
