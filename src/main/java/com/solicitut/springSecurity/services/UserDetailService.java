package com.solicitut.springSecurity.services;

import com.solicitut.springSecurity.models.User;
import com.solicitut.springSecurity.repositories.UserRepository;
import com.solicitut.springSecurity.utils.UserDetailsCustom;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if(user == null) {
      throw new UsernameNotFoundException(username);
    }

    return new UserDetailsCustom(user);
  }
}
