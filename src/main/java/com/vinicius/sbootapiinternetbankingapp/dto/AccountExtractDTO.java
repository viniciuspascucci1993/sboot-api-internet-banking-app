package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountExtract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountExtractDTO {

    private Long id;
    private String descriptionExtract;
    private List<AccountBankingExtractDTO> accountBankingExtracts;

    public AccountExtractDTO(AccountExtract entity) {
        this.id = entity.getId();
        this.descriptionExtract = entity.getDescriptionExtract();
    }
}
