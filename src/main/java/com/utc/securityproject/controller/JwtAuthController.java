package com.utc.securityproject.controller;

import com.hina.socialmedia.dto.request.LoginRequest;
import com.hina.socialmedia.service.impl.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class JwtAuthController {

  @Autowired
  private JwtService jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("generate-token")
  public String generateToken(@Valid @RequestBody LoginRequest request) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    if (authentication.isAuthenticated()) {
      return jwtService.generateToken(request.getEmail());
    } else {
      throw new UsernameNotFoundException("Invalid User Request "+ request.getEmail());
    }
  }
}
