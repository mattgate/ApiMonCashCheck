package com.devMattgate.ApiMonCashCheck.service.impl;

import com.devMattgate.ApiMonCashCheck.entities.Account;
import com.devMattgate.ApiMonCashCheck.persistence.IAccountRepository;
import com.devMattgate.ApiMonCashCheck.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
