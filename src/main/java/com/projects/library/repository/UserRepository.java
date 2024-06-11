package com.projects.library.repository;

import com.projects.library.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}
