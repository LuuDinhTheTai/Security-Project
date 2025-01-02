package com.utc.securityproject.controller;

import com.utc.securityproject.constants.Constant;
import com.utc.securityproject.dto.request.RegisterRequest;
import com.utc.securityproject.dto.response.AccountDTO;
import com.utc.securityproject.entity.Account;
import com.utc.securityproject.mapper.AccountMapper;
import com.utc.securityproject.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountController {
  private final AccountService accountService;
  private final PasswordEncoder passwordEncoder;
  
  public AccountController(AccountService accountService, PasswordEncoder passwordEncoder) {
    this.accountService = accountService;
    this.passwordEncoder = passwordEncoder;
  }
  
  @PostMapping("/register")
  public Account create(@Valid @RequestBody RegisterRequest request) {
    request.validate();
    
    Account account = new Account();
    account.setUsername((request.getUsername()));
    account.setEmail(request.getEmail());
    account.setPassword(passwordEncoder.encode(request.getPassword()));
    
    return accountService.create(account);
  }
  
  @GetMapping("/profile")
  public Account find(@RequestParam String id) {
    return (accountService.find(id));
  }
}
