package com.vinicius.sbootapiinternetbankingapp.service;

import com.vinicius.sbootapiinternetbankingapp.dto.BankAccountDetailingDTO;
import com.vinicius.sbootapiinternetbankingapp.repository.BankAccountDetailingRepository;
import com.vinicius.sbootapiinternetbankingapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankingAccountDetailingService {

    @Autowired
    private BankAccountDetailingRepository bankAccountDetailingRepository;

    public BankAccountDetailingDTO getBankAccountDetailingDTO(Long accountId) {
        if (accountId == null) {
            throw new ResourceNotFoundException("Account ID: " + accountId +" Not Found");
        }

        return bankAccountDetailingRepository.getBankAccountDetailingDTOById(accountId);
    }
}
