package com.utc.securityproject.security;

import com.hina.socialmedia.entity.Account;
import com.hina.socialmedia.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> account = repo.findByEmail(email);

        return account.map(acc -> new CustomUserDetails(acc))
                .orElseThrow(() -> new UsernameNotFoundException("Account Not Found"));
    }
}
