package com.vinicius.sbootapiinternetbankingapp.controller;

import com.vinicius.sbootapiinternetbankingapp.dto.BankAccountDetailingDTO;
import com.vinicius.sbootapiinternetbankingapp.service.BankingAccountDetailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/internet-banking/banking")
public class BankingAccountDetailingController {

    @Autowired
    private BankingAccountDetailingService bankingAccountDetailingService;

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountDetailingDTO> findBankAccount(@PathVariable("id") final Long id) {
        return ResponseEntity.ok().body(bankingAccountDetailingService.getBankAccountDetailingDTO(id));
    }
}
