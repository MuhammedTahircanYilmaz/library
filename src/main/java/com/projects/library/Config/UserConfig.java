package com.projects.library.Config;

import com.projects.library.model.UserEntity;
import com.projects.library.repository.CustomUserEntityDetails;
import com.projects.library.repository.UserEntityRepository;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfig {

    @Bean
    public UserEntity user(){
        return new UserEntity();
    }

    @Bean
    public CustomUserEntityDetails userEntityDetails(UserEntity user){
        return new CustomUserEntityDetails(user);
    }
}
