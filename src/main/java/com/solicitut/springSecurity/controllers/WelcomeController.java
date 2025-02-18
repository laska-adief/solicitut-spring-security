package com.solicitut.springSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;

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

  @GetMapping("csrf")
  public CsrfToken getToken(HttpServletRequest request) {
    return (CsrfToken) request.getAttribute("_csrf");
  }

}
