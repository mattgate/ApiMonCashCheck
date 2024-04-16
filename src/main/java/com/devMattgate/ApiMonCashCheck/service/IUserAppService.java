package com.devMattgate.ApiMonCashCheck.service;

import com.devMattgate.ApiMonCashCheck.entities.UserApp;

import java.util.List;
import java.util.Optional;

public interface IUserAppService {
    void save(UserApp userApp);

    List<UserApp> findAll();

    Optional<UserApp> findById(Long Id);

    void deleteById(Long Id);
}
