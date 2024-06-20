package com.projects.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Table(name = "user_entity")
public class UserEntity{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        @Column("username")
        @NotBlank
        String username;
        @Column("email")
        @NotBlank
        String email;
        @Column("password")
        String password;
}
