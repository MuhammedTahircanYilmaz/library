package com.projects.library.service;

import com.projects.library.dto.UserEntityDto;
import com.projects.library.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;

public interface UserService {

    void save(UserEntityDto userEntityDto);
    UserEntity findUserByEmail(String email);
    UserEntity findUserByUsername(String username);
}
