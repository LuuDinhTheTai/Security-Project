package com.utc.securityproject.service.impl;

import com.hina.socialmedia.entity.Account;
import com.hina.socialmedia.repository.AccountRepository;
import com.hina.socialmedia.service.AccountService;
import com.hina.socialmedia.service.base.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    public AccountServiceImpl(AccountRepository accountRepository) {
        super(accountRepository);
    }
}
