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
@Builder
@Getter
@Table(name = "user_entity")
public class UserEntity{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
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
                name="users_roles",
                joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
                inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
        private List<Role> roles = new ArrayList<>();
}
