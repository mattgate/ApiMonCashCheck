package com.devMattgate.ApiMonCashCheck.controller;

import com.devMattgate.ApiMonCashCheck.entities.UserApp;
import com.devMattgate.ApiMonCashCheck.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userapp")
public class UserAppController {

    @Autowired
    private IUserAppService iUserAppService;

    public void saveUserApp(@RequestBody UserApp userApp){
        iUserAppService.save(userApp);
    }
}
