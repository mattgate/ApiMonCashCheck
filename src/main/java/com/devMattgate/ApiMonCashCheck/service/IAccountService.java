package com.devMattgate.ApiMonCashCheck.service;

import com.devMattgate.ApiMonCashCheck.entities.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    void save(Account account);

    List<Account> findAll();

    Optional<Account> findById(Long id);

    void deleteById(Long id);

}
