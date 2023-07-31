package com.vinicius.sbootapiinternetbankingapp.util;

import com.vinicius.sbootapiinternetbankingapp.dto.AccountBankingExtractDTO;
import com.vinicius.sbootapiinternetbankingapp.dto.BankCardDataDTO;
import com.vinicius.sbootapiinternetbankingapp.dto.ContactDataDTO;
import com.vinicius.sbootapiinternetbankingapp.entities.AccountBankingExtract;
import com.vinicius.sbootapiinternetbankingapp.entities.BankCardData;
import com.vinicius.sbootapiinternetbankingapp.entities.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {

    public static List<BankCardDataDTO> convertBankCardDataToDtoList(List<BankCardData> bankCardDataList) {
        List<BankCardDataDTO> bankCardDataDTOList = new ArrayList<>();

        for (BankCardData bankCardData : bankCardDataList) {
            bankCardDataDTOList.add(new BankCardDataDTO(
                    bankCardData.getId(), bankCardData.getName(), bankCardData.getFlagCreditCard(),
                    bankCardData.getTypeCreditCard(), bankCardData.getLimitCreditCard(),
                    bankCardData.getBankDetailingAccount()
            ));
        }
        return bankCardDataDTOList;
    }

    public static ContactDataDTO convertContactDataToDto(ContactData contactData) {
        if (contactData == null) {
            return null;
        }
        return new ContactDataDTO(contactData.getId(), contactData.getPhone(),
                contactData.getStreetOrAvenue(),
                contactData.getEmail());
    }

    public static List<AccountBankingExtractDTO> convertAccountBankingExtractToDtoList(List<AccountBankingExtract>
                                          accountBankingExtracts) {
        List<AccountBankingExtractDTO> accountBankingExtractDTOArrayList = new ArrayList<>();

        for (AccountBankingExtract accountBankingExtract : accountBankingExtracts) {
            accountBankingExtractDTOArrayList.add(new AccountBankingExtractDTO(
                    accountBankingExtract.getId(), accountBankingExtract.getCurrentDate(),
                    accountBankingExtract.getBalanceCurrentDate(), accountBankingExtract.getCategoryName(),
                    accountBankingExtract.getDescription(), accountBankingExtract.getPendencyAmount()
            ));
        }

        return accountBankingExtractDTOArrayList;
    }
}
