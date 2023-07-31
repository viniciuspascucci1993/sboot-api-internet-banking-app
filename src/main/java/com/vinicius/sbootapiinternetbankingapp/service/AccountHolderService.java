package com.vinicius.sbootapiinternetbankingapp.service;

import com.vinicius.sbootapiinternetbankingapp.dto.AccountHolderPostDTO;
import com.vinicius.sbootapiinternetbankingapp.dto.AccountHolderGetDTO;
import com.vinicius.sbootapiinternetbankingapp.dto.BankDetailDTO;
import com.vinicius.sbootapiinternetbankingapp.entities.AccountHolder;
import com.vinicius.sbootapiinternetbankingapp.entities.BankDetail;
import com.vinicius.sbootapiinternetbankingapp.repository.AccountHolderRepository;
import com.vinicius.sbootapiinternetbankingapp.service.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public AccountHolderPostDTO insert(AccountHolderPostDTO accountHolderPostDTO) {

        AccountHolder entity = new AccountHolder();
        BeanUtils.copyProperties(accountHolderPostDTO, entity);

        entity = accountHolderRepository.save(entity);
        return new AccountHolderPostDTO(entity);
    }

    @Transactional(readOnly = true)
    public AccountHolderGetDTO findById(Long id) {

        log.info("Iniciando consulta pelo ID do Correntista...{}", id);

        Optional<AccountHolder> accountHolder = accountHolderRepository.findById(id);

        if (accountHolder.isEmpty()) {
            throw new ResourceNotFoundException("Account Holder Não encontrado");
        } else {
            AccountHolderGetDTO accountHolderDTO = new AccountHolderGetDTO();
            accountHolderDTO.setId(accountHolder.get().getId());
            accountHolderDTO.setName(accountHolder.get().getName());
            accountHolderDTO.setEmail(accountHolder.get().getEmail());
            accountHolderDTO.setCpfOrCnpj(accountHolder.get().getCpfOrCnpj());
            accountHolderDTO.setBirthDate(accountHolder.get().getBirthDate());
            accountHolderDTO.setAccountHolderSince(accountHolder.get().getAccountHolderSince());
            accountHolderDTO.setBalance(accountHolder.get().getBalance());

            List<BankDetailDTO> bankDetailDTOList = accountHolder.get().getBankDatas().stream()
                    .map(this::convertToDto)
                    .toList();

            accountHolderDTO.setBankDatas(bankDetailDTOList);
            return accountHolderDTO;
        }
    }

    private BankDetailDTO convertToDto(BankDetail bankDetail) {
        BankDetailDTO dto = new BankDetailDTO();
        dto.setId(bankDetail.getId());
        dto.setBankName(bankDetail.getBankName());
        dto.setCodeBank(bankDetail.getCodeBank());
        dto.setAgency(bankDetail.getAgency());
        dto.setAccount(bankDetail.getAccount());

        return dto;

    }
}
