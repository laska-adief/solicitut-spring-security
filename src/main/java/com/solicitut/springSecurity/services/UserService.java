package com.solicitut.springSecurity.services;

import com.solicitut.springSecurity.models.User;
import com.solicitut.springSecurity.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User register(@RequestBody User user) {
    return userRepository.save(user);
  }
}
