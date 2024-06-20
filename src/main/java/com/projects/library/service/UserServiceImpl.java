package com.projects.library.service;

import com.projects.library.model.UserEntity;
import com.projects.library.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(UserEntity userEntity) {
        String hashedPassword = bCryptPasswordEncoder.encode(userEntity.getPassword());
        UserEntity newUserEntity = new UserEntity(userEntity.getId(), userEntity.getUsername(), userEntity.getEmail(), hashedPassword);
        userRepository.save(newUserEntity);
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
