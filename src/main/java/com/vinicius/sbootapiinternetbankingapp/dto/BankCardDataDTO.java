package com.vinicius.sbootapiinternetbankingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vinicius.sbootapiinternetbankingapp.entities.BankAccountDetailing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCardDataDTO {

    private Long id;
    private String name;
    private String flagCreditCard;
    private String typeCreditCard;
    private BigDecimal limitCreditCard;
    @JsonIgnore
    private BankAccountDetailing bankDetailingAccount;
}
