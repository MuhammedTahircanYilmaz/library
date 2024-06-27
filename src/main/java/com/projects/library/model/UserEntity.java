package com.projects.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Table(name = "user_entity")
public class UserEntity{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;

        @Column("username")
        @NotBlank
        private String username;

        @Column("email")
        @NotBlank
        private String email;

        @Column("password")
        private String password;

        @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
        @JoinTable(
                name="user_entity_roles",
                joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="user_id")},
                inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="id")})
        private List<Role> roles = new ArrayList<>();
}
