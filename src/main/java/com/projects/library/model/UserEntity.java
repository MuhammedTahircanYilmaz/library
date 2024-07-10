package com.projects.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_entity")
public class UserEntity{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long userId;

        @Column(name = "username", unique = true)
        @NotBlank
        private String username;

        @Column(name = "email", unique = true)
        @NotBlank
        private String email;

        @Column(name = "password")
        private String password;

        @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
        @JoinTable(
                name="user_entity_roles",
                joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="user_id")},
                inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="id")})
        private List<Role> roles = new ArrayList<>();
}
