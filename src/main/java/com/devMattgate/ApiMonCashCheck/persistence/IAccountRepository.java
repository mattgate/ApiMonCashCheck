package com.devMattgate.ApiMonCashCheck.persistence;

import com.devMattgate.ApiMonCashCheck.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends CrudRepository<Account,Long> {
}
