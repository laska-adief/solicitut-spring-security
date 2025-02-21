package com.solicitut.springSecurity.controllers;

import com.solicitut.springSecurity.models.User;
import com.solicitut.springSecurity.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("register")
  public User register(@RequestBody User user) {
    return userService.register(user);
  }
}
