package com.projects.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

@Table(name = "user")
public record User(
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
