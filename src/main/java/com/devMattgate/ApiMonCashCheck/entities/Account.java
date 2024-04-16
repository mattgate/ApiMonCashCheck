package com.devMattgate.ApiMonCashCheck.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private Date dateCreate;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "userAppId")
    @JsonIgnore
    private UserApp userApp;
}
