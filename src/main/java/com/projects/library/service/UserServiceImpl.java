package com.projects.library.service;

import com.projects.library.dto.UserEntityDto;
import com.projects.library.model.UserEntity;
import com.projects.library.repository.UserEntityRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserEntityRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public void save(UserEntityDto userEntityDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userEntityDto.getUsername());
        userEntity.setEmail(userEntityDto.getEmail());
        String hashedPassword = bCryptPasswordEncoder.encode(userEntityDto.getPassword());
        userEntity.setPassword(hashedPassword);
        userRepository.save(userEntity);
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
