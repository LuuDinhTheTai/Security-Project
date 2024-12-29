package com.utc.securityproject.service.impl;

import com.utc.securityproject.entity.Account;
import com.utc.securityproject.repository.AccountRepository;
import com.utc.securityproject.service.AccountService;
import com.utc.securityproject.service.base.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    public AccountServiceImpl(AccountRepository accountRepository) {
        super(accountRepository);
    }
}
