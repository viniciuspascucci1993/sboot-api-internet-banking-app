package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountExtract;
import com.vinicius.sbootapiinternetbankingapp.entities.TransactionHistory;
import com.vinicius.sbootapiinternetbankingapp.util.ConvertUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistoryDTO {

    private Long id;
    private String financialActivity;

    public TransactionHistoryDTO(TransactionHistory entity) {
        this.id = entity.getId();
        this.financialActivity = entity.getFinancialActivity();
    }
}
