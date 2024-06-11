package com.projects.library.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    public static final String USER= "user";
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/login")
                    .permitAll()
                    .requestMatchers(HttpMethod.GET)
                    .permitAll()
                    .requestMatchers(HttpMethod.PUT)
                    .hasAuthority(USER)
                    .requestMatchers(HttpMethod.POST)
                    .permitAll()
                    .requestMatchers(HttpMethod.DELETE)
                    .hasAuthority(USER)
                    .anyRequest()
                    .authenticated());
        http.csrf(c-> c.disable());
        return http.build();
    }
}

