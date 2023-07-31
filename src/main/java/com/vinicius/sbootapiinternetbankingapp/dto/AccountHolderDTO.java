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
public class AccountHolderDTO {

    private Long id;
    private String name;
    private String motherName;
    private String fatherName;
    private LocalDate birthDate;
    private String customerSince;
    private BigDecimal balance;
    private Integer jobCode;
    private String jobTitle;

    public AccountHolderDTO(AccountHolder entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.motherName = entity.getMotherName();
        this.fatherName = entity.getFatherName();
        this.birthDate = entity.getBirthDate();
        this.customerSince = entity.getCustomerSince();
        this.balance = entity.getBalance();
        this.jobCode = entity.getJobCode();
        this.jobTitle = entity.getJobTitle();
    }
}
