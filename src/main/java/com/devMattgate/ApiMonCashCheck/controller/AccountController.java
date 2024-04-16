package com.devMattgate.ApiMonCashCheck.controller;

import com.devMattgate.ApiMonCashCheck.dto.AccountDTO;
import com.devMattgate.ApiMonCashCheck.entities.Account;
import com.devMattgate.ApiMonCashCheck.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("/")
    public ResponseEntity<?> allAccounts(){
        List<AccountDTO> accountDTOList = accountService.findAll()
                .stream()
                .map(account -> AccountDTO.builder()
                        .accountName(account.getAccountName())
                        .dateCreate(account.getDateCreate())
                        .totalAmount(account.getTotalAmount())
                        .userApp(account.getUserApp())
                        .build()
                ).toList();

        return ResponseEntity.ok(accountDTOList);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody AccountDTO accountDTO){
        accountService.save(Account.builder()
                .accountName(accountDTO.getAccountName())
                .totalAmount(accountDTO.getTotalAmount())
                .dateCreate(accountDTO.getDateCreate())
                .userApp(accountDTO.getUserApp()).build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable("id") Long id){
        Optional<Account> accountOptional = accountService.findById(id);

        if (accountOptional.isPresent()){
            Account account = accountOptional.get();
            AccountDTO accountDTO = AccountDTO.builder()
                    .accountName(account.getAccountName())
                    .dateCreate(account.getDateCreate())
                    .totalAmount(account.getTotalAmount())
                    .userApp(account.getUserApp()).build();

            return ResponseEntity.ok(accountDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountById(@PathVariable("id") Long id){
        if (id != null){
            accountService.deleteById(id);
            return ResponseEntity.ok("Se eliminó el dato correctamente");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccontById(@PathVariable("id") Long id, @RequestBody AccountDTO accountDTO){

        Optional<Account> accountOptional = accountService.findById(id);

        if (accountOptional.isPresent()){
            Account account = accountOptional.get();
            account.setAccountName(accountDTO.getAccountName());
            account.setDateCreate(accountDTO.getDateCreate());
            account.setTotalAmount(accountDTO.getTotalAmount());
            account.setUserApp(accountDTO.getUserApp());

            accountService.save(account);

            return ResponseEntity.ok("Se actualizó el dato correctamente");

        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
