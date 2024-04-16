package com.devMattgate.ApiMonCashCheck.dto;

import com.devMattgate.ApiMonCashCheck.entities.UserApp;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AccountDTO {
    private String accountName;
    private Date dateCreate;
    private Double totalAmount;
    private UserApp userApp;
}
