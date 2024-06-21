package com.projects.library.Security;

import com.projects.library.model.Role;
import com.projects.library.model.UserEntity;
import com.projects.library.repository.UserEntityRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private UserEntityRepository userEntityRepository;

    public CustomUserDetailsService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userEntityRepository.findByUsername(username);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles){
        Collection< ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role-> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
