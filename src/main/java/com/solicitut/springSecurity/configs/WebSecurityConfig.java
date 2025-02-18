package com.solicitut.springSecurity.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

//  UserDetailsService interface is used for retrieving user-related data for authentication
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails john = User.withUsername("john").password("john").roles("USER").build();
    UserDetails alice = User.withUsername("alice").password("alice").roles("USER").build();

//    Given that there is no default password encoder configured,
//    each password must have a password encoding prefix.
//    Please either prefix this password with '{noop}'
//    or set a default password encoder in `DelegatingPasswordEncoder`.
    UserDetails noop = User.withUsername("noop").password("{noop}noop").roles("USER").build();

    return new InMemoryUserDetailsManager(john, alice, noop);
  }
}
