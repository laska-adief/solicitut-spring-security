package com.solicitut.springSecurity.services;

import com.solicitut.springSecurity.models.User;
import com.solicitut.springSecurity.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User register(@RequestBody User user) {
    return userRepository.save(user);
  }

  public User login(User user) {
    Optional<User> optionalUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    return optionalUser.orElse(null);
  }
}
