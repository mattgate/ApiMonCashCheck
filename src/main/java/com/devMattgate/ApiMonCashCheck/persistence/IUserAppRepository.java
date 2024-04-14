package com.devMattgate.ApiMonCashCheck.persistence;

import com.devMattgate.ApiMonCashCheck.entities.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAppRepository extends CrudRepository<UserApp,Long> {
}
