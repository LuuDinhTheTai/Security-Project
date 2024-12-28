package com.utc.securityproject.repository;

import com.hina.socialmedia.entity.Account;
import com.hina.socialmedia.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends BaseRepository<Account> {
    Optional<Account> findByEmail(String email);
    boolean existsByEmail(String email);
}
