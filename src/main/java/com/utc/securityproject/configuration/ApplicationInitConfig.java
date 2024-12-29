package com.utc.securityproject.configuration;

import java.util.HashSet;

import com.utc.securityproject.constants.Constant;
import com.utc.securityproject.entity.Account;
import com.utc.securityproject.entity.Role;
import com.utc.securityproject.repository.AccountRepository;
import com.utc.securityproject.repository.RoleRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
  
  PasswordEncoder passwordEncoder;
  
  @NonFinal
  static final String ADMIN_USER_NAME = "admin";
  
  @NonFinal
  static final String ADMIN_PASSWORD = "admin";
  
  @Bean
  @ConditionalOnProperty(
          prefix = "spring",
          value = "datasource.driverClassName",
          havingValue = "com.mysql.cj.jdbc.Driver")
  ApplicationRunner applicationRunner(AccountRepository accountRepository, RoleRepository roleRepository) {
    log.info("Initializing application.....");
    return args -> {
      if (accountRepository.findByUsername(ADMIN_USER_NAME).isEmpty()) {
        roleRepository.save(Role.builder()
                                    .name(Constant.USER_ROLE)
                                    .description("User role")
                                    .build());
        
        Role adminRole = roleRepository.save(Role.builder()
                                                     .name(Constant.ADMIN_ROLE)
                                                     .description("Admin role")
                                                     .build());
        
        var roles = new HashSet<Role>();
        roles.add(adminRole);
        
        Account account = Account.builder()
                            .username(ADMIN_USER_NAME)
                            .password(passwordEncoder.encode(ADMIN_PASSWORD))
                            .roles(roles)
                            .build();
        
        accountRepository.save(account);
        log.warn("admin user has been created with default password: admin, please change it");
      }
      log.info("Application initialization completed .....");
    };
  }
}

