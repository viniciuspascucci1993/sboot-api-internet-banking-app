package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolderGetDTO {

    private Long id;
    private String name;
    private String email;
    private Long cpfOrCnpj;
    private LocalDate birthDate;
    private String accountHolderSince;
    private BigDecimal balance;

    public AccountHolderGetDTO(AccountHolder entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.cpfOrCnpj = entity.getCpfOrCnpj();
        this.birthDate = entity.getBirthDate();
        this.balance = entity.getBalance();
        this.accountHolderSince = entity.getAccountHolderSince();
    }
}
