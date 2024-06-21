package com.projects.library.service;

import com.projects.library.dto.UserEntityDto;
import com.projects.library.model.Role;
import com.projects.library.model.UserEntity;
import com.projects.library.repository.RoleRepository;
import com.projects.library.repository.UserEntityRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private UserEntityRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder PasswordEncoder;

    public UserServiceImpl(UserEntityRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.PasswordEncoder = passwordEncoder;
    }


    @Override
    public void save(UserEntityDto userEntityDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userEntityDto.getUsername());
        userEntity.setEmail(userEntityDto.getEmail());
        String hashedPassword = PasswordEncoder.encode(userEntityDto.getPassword());
        userEntity.setPassword(hashedPassword);

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){role = checkRoleExist();
        }
        userEntity.setRoles(Arrays.asList(role));

        userRepository.save(userEntity);
    }

    private UserEntityDto mapToUserDto(UserEntity user){
        UserEntityDto userDto = new UserEntityDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
