package com.devMattgate.ApiMonCashCheck.controller;

import com.devMattgate.ApiMonCashCheck.dto.UserAppDTO;
import com.devMattgate.ApiMonCashCheck.entities.UserApp;
import com.devMattgate.ApiMonCashCheck.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/userapp")
public class UserAppController {

    @Autowired
    private IUserAppService UserAppService;

    @GetMapping("/")
    public ResponseEntity<?> allUsersApp(){
        List<UserAppDTO> userAppDTOList = UserAppService.findAll()
                                                        .stream()
                                                        .map(userApp -> UserAppDTO.builder()
                                                                .name(userApp.getName())
                                                                .lastName(userApp.getLastName())
                                                                .accountList(userApp.getAccountList())
                                                                .build()
                                                        ).toList();

        return ResponseEntity.ok(userAppDTOList);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUserApp(@RequestBody UserAppDTO userAppDTO){
        UserAppService.save(UserApp.builder()
                .name(userAppDTO.getName())
                .lastName(userAppDTO.getLastName())
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserAppById(@PathVariable("id") Long id){
        Optional<UserApp> userAppOptional= UserAppService.findById(id);

        if (userAppOptional.isPresent()){
            UserApp userApp = userAppOptional.get();
            UserAppDTO userAppDTO = UserAppDTO.builder()
                    .name(userApp.getName())
                    .lastName(userApp.getLastName())
                    .accountList(userApp.getAccountList())
                    .build();

            return ResponseEntity.ok(userAppDTO);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserAppById(@PathVariable("id") Long id){

        if (id != null) {
            UserAppService.deleteById(id);

            return ResponseEntity.ok("Se eliminó el dato correctamente");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateUserAppById(@PathVariable("id") Long id, @RequestBody UserAppDTO userAppDTO){
        Optional<UserApp>  userAppOptional = UserAppService.findById(id);

        if (userAppOptional.isPresent()){
            UserApp userApp = userAppOptional.get();
            userApp.setName(userAppDTO.getName());
            userApp.setLastName(userAppDTO.getLastName());
            UserAppService.save(userApp);
            return ResponseEntity.ok("Se actualizó el dato correctamente");
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
