package com.devMattgate.ApiMonCashCheck.dto;

import com.devMattgate.ApiMonCashCheck.entities.Account;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserAppDTO {
    private String name;
    private String lastName;
    private List<Account> accountList;
}
