package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountBankingExtract;
import com.vinicius.sbootapiinternetbankingapp.entities.BankAccountDetailing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static com.vinicius.sbootapiinternetbankingapp.util.ConvertUtil.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDetailingDTO {

    private Long id;
    private String fullNameAccountHolder;
    private Integer numberBank;
    private Long numberBankAccount;
    private Long cpfOrCnpjAccountHolder;
    private ContactDataDTO contactData;
    private List<AccountBankingExtractDTO> accountBankingExtracts;
    private BigDecimal balanceAccount;
    private List<BankCardDataDTO> bankCardDataList;

    public BankAccountDetailingDTO(BankAccountDetailing entity) {
        this.id = entity.getId();
        this.fullNameAccountHolder = entity.getFullNameAccountHolder();
        this.numberBank = entity.getNumberBank();
        this.numberBankAccount = entity.getNumberBankAccount();
        this.cpfOrCnpjAccountHolder = entity.getCpfOrCnpjAccountHolder();
        this.contactData = convertContactDataToDto(entity.getContactData());
        this.accountBankingExtracts = convertAccountBankingExtractToDtoList(entity.getAccountBankingExtracts());
        this.balanceAccount = entity.getBalanceAccount();
        this.bankCardDataList = convertBankCardDataToDtoList(entity.getBankCardDataList());

    }
}
