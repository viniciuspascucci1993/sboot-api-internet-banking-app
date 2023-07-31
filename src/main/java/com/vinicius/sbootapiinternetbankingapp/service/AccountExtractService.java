package com.vinicius.sbootapiinternetbankingapp.service;
import com.vinicius.sbootapiinternetbankingapp.dto.AccountBankingExtractDTO;
import com.vinicius.sbootapiinternetbankingapp.dto.AccountExtractDTO;
import com.vinicius.sbootapiinternetbankingapp.entities.AccountBankingExtract;
import com.vinicius.sbootapiinternetbankingapp.entities.AccountExtract;
import com.vinicius.sbootapiinternetbankingapp.repository.AccountExtractRepository;
import com.vinicius.sbootapiinternetbankingapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountExtractService {

    @Autowired
    private AccountExtractRepository accountExtractRepository;

    public AccountExtractDTO findById(Long extractId) {

        AccountExtract accountExtract = accountExtractRepository.findById(extractId).orElse(null);

        if (accountExtract == null) {
            throw new ResourceNotFoundException("Extrato do Correntista de ID: " + extractId + " Não encontrado.");
        }

        AccountExtractDTO accountExtractDTO = new AccountExtractDTO();
        accountExtractDTO.setId(accountExtract.getId());
        accountExtractDTO.setDescriptionExtract(accountExtract.getDescriptionExtract());

        List<AccountBankingExtractDTO> accountBankingExtractDTOList =
                    accountExtract.getAccountBankingExtracts().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        accountExtractDTO.setAccountBankingExtracts(accountBankingExtractDTOList);
        return accountExtractDTO;
    }

    private AccountBankingExtractDTO convertToDto(AccountBankingExtract accountBankingExtract) {
        AccountBankingExtractDTO accountBankingExtractDTO = new AccountBankingExtractDTO();
        accountBankingExtractDTO.setId(accountBankingExtract.getId());
        accountBankingExtractDTO.setCurrentDate(accountBankingExtract.getCurrentDate());
        accountBankingExtractDTO.setBalanceCurrentDate(accountBankingExtract.getBalanceCurrentDate());
        accountBankingExtractDTO.setCategoryName(accountBankingExtract.getCategoryName());
        accountBankingExtractDTO.setDescription(accountBankingExtract.getDescription());
        accountBankingExtractDTO.setPendencyAmount(accountBankingExtract.getPendencyAmount());

        return accountBankingExtractDTO;
    }
}
