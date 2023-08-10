package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.BalanceAccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceAccountHolderDTO {

    private Long id;
    private String nameAccountHolder;
    private BigDecimal currentBalanceAccountHolder;
    private BigDecimal updatedBalanceAccountHolder;
    private String description;

    public BalanceAccountHolderDTO(BalanceAccountHolder entity) {
        this.id = entity.getId();
        this.nameAccountHolder = entity.getNameAccountHolder();
        this.currentBalanceAccountHolder = entity.getCurrentBalanceAccountHolder();
        this.updatedBalanceAccountHolder = entity.getUpdatedBalanceAccountHolder();
        this.description = entity.getDescription();
    }
}
