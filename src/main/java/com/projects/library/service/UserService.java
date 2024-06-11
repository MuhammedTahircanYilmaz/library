package com.projects.library.service;

import com.projects.library.model.UserEntity;
import com.projects.library.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(UserEntity userEntity) {
        String hashedPassword = bCryptPasswordEncoder.encode(userEntity.password());
        UserEntity newUserEntity = new UserEntity(userEntity.id(), userEntity.username(), userEntity.email(), hashedPassword);
        userRepository.save(newUserEntity);
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
