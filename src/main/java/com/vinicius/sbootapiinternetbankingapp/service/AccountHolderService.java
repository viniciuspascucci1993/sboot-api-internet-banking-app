package com.vinicius.sbootapiinternetbankingapp.service;

import com.vinicius.sbootapiinternetbankingapp.dto.AccountHolderDTO;
import com.vinicius.sbootapiinternetbankingapp.entities.AccountHolder;
import com.vinicius.sbootapiinternetbankingapp.repository.AccountHolderRepository;
import com.vinicius.sbootapiinternetbankingapp.service.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class AccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public AccountHolderDTO insert(AccountHolderDTO accountHolderDTO) {

        AccountHolder entity = new AccountHolder();
        BeanUtils.copyProperties(accountHolderDTO, entity);

        entity = accountHolderRepository.save(entity);
        log.info("Account Holder Inserido com sucesso...");

        return new AccountHolderDTO(entity);
    }

    @Transactional(readOnly = true)
    public AccountHolderDTO findById(Long id ) {

        Optional<AccountHolder> obj = accountHolderRepository.findById(id);
        AccountHolder entities = obj.orElseThrow(() -> new ResourceNotFoundException("Correntista não econtrado"));

        return new AccountHolderDTO(entities);
    }
}
