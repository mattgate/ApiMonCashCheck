package com.devMattgate.ApiMonCashCheck.service.impl;

import com.devMattgate.ApiMonCashCheck.entities.UserApp;
import com.devMattgate.ApiMonCashCheck.persistence.IUserAppRepository;
import com.devMattgate.ApiMonCashCheck.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAppServiceImpl implements IUserAppService {

    @Autowired
    private IUserAppRepository userAppRepository;

    @Override
    public void save(UserApp userApp) {
        userAppRepository.save(userApp);
    }

    @Override
    public List<UserApp> findAll() {
        return  (List<UserApp>) userAppRepository.findAll();
    }

    @Override
    public Optional<UserApp> findById(Long Id) {
        return userAppRepository.findById(Id);
    }

    @Override
    public void deleteById(Long Id) {
        userAppRepository.deleteById(Id);
    }

}
