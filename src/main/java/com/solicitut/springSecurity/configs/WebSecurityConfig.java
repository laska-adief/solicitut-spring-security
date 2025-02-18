package com.solicitut.springSecurity.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
//      All request will need to be authenticated, unauthenticated request will return 403 Forbidden
      .authorizeHttpRequests(authorizeRequests ->
        authorizeRequests.anyRequest().authenticated()
      );
    return http.build();
  }
}
