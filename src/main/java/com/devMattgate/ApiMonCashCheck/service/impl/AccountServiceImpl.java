package com.devMattgate.ApiMonCashCheck.service.impl;

import com.devMattgate.ApiMonCashCheck.entities.Account;
import com.devMattgate.ApiMonCashCheck.persistence.IAccountRepository;
import com.devMattgate.ApiMonCashCheck.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
