package com.projects.library.service;

import com.projects.library.dto.UserEntityDto;
import com.projects.library.model.UserEntity;
import org.apache.catalina.User;

public interface UserService {

    void save(UserEntityDto userEntityDto);

    UserEntity findUserByEmail(String email);
}
