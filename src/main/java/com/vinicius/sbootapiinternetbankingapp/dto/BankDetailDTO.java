package com.vinicius.sbootapiinternetbankingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vinicius.sbootapiinternetbankingapp.entities.AccountHolder;
import com.vinicius.sbootapiinternetbankingapp.entities.BankDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetailDTO {

    private Long id;
    private String bankName;
    private Integer codeBank;
    private Integer agency;
    private String account;
    @JsonIgnore
    private AccountHolder accountHolder;

    public BankDetailDTO(BankDetail entity) {
        this.id = entity.getId();
        this.bankName = entity.getBankName();
        this.codeBank = entity.getCodeBank();
        this.agency = entity.getAgency();
        this.account = entity.getAccount();
    }
}
