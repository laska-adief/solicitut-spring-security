package com.solicitut.springSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @GetMapping("")
  public String home() {
    return "Hello World";
  }

  @GetMapping("greet")
  public String greet() {
    return "Buenos Dias";
  }

}
