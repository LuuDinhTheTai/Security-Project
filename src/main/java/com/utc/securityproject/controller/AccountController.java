package com.utc.securityproject.controller;

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
  private final AccountMapper accountMapper;
  
  public AccountController(AccountService accountService, PasswordEncoder passwordEncoder, AccountMapper accountMapper) {
    this.accountService = accountService;
    this.passwordEncoder = passwordEncoder;
    this.accountMapper = accountMapper;
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
  public AccountDTO find(@RequestParam String id) {
    return accountMapper.toDTO(accountService.find(id));
  }
}
