package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountBankingExtract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBankingExtractDTO {

    private Long id;
    private LocalDate currentDate;
    private BigDecimal balanceCurrentDate;
    private String categoryName;
    private String description;
    private BigDecimal pendencyAmount;

    public AccountBankingExtractDTO(AccountBankingExtract entity) {
        this.id = entity.getId();
        this.currentDate = entity.getCurrentDate();
        this.balanceCurrentDate = entity.getBalanceCurrentDate();
        this.categoryName = entity.getCategoryName();
        this.description = entity.getDescription();
        this.pendencyAmount = entity.getPendencyAmount();
    }
}
