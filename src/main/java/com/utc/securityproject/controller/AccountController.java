package com.utc.securityproject.controller;

import com.hina.socialmedia.dto.request.RegisterRequest;
import com.hina.socialmedia.dto.response.AccountDTO;
import com.hina.socialmedia.entity.Account;
import com.hina.socialmedia.mapper.AccountMapper;
import com.hina.socialmedia.service.AccountService;
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
    account.setEmail(request.getEmail());
    account.setPassword(passwordEncoder.encode(request.getPassword()));
    
    return accountService.create(account);
  }
  
  @GetMapping("/profile")
  public AccountDTO find(@RequestParam Long id) {
    return AccountMapper.toDTO(accountService.find(id));
  }
}
