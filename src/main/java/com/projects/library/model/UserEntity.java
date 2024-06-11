package com.projects.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.relational.core.mapping.Column;

@Entity
@Table(name = "user")
public record UserEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id,
        @Column("username")
        @NotBlank
        String username,
        @Column("email")
        @NotBlank
        String email,
        @Column("password")
        String password
){}
