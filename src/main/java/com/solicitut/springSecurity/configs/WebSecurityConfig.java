package com.solicitut.springSecurity.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http

//      Disable csrf auth
      .csrf(csrf -> csrf.disable())

//      All request will need to be authenticated, unauthenticated request will return 403 Forbidden
      .authorizeHttpRequests(authorizeRequests ->
        authorizeRequests.anyRequest().authenticated()
      )
//      Default Config authentication
//      In Browser display popup to input username and password
//      In Postman set the Authorization -> Auth Type (Basic Auth) -> set username and password
//      Username and Password is based on that set in Spring Security Config in application.properties
      .httpBasic(Customizer.withDefaults())

//      Instead of popup it will display form to input username and password
      .formLogin(Customizer.withDefaults());
    return http.build();
  }
}
