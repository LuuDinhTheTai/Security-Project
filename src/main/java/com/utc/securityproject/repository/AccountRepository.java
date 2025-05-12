package com.utc.securityproject.repository;

import com.utc.securityproject.entity.Account;
import com.utc.securityproject.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends BaseRepository<Account> {
  
  Optional<Account> findByEmail(String email);
  boolean existsByEmail(String email);
  Optional<Account> findByUsername(String username);
}
