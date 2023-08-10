package com.vinicius.sbootapiinternetbankingapp.controller;

import com.vinicius.sbootapiinternetbankingapp.dto.BalanceAccountHolderDTO;
import com.vinicius.sbootapiinternetbankingapp.service.BalanceAccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/internet-banking/balances")
public class BalanceAccountHolderController {

    @Autowired
    private BalanceAccountHolderService balanceAccountHolderService;

    @GetMapping("/depositValue/{id}/{depositAmount}")
    public ResponseEntity<BalanceAccountHolderDTO> depositarValor(@PathVariable("id") Long id,
                                                               @PathVariable("depositAmount") Double depositAmount) {
        BalanceAccountHolderDTO balanceAccountHolderDTO =
                balanceAccountHolderService.getDepositValue(id, depositAmount);
        return ResponseEntity.ok(balanceAccountHolderDTO);
    }


    @GetMapping("/withdrawValue/{id}/{value}")
    public ResponseEntity<BalanceAccountHolderDTO> withDrawValue(@PathVariable("id") Long id,
                                                              @PathVariable("value") Double value) {
        BalanceAccountHolderDTO balanceAccountHolderDTO =
                balanceAccountHolderService.getWithDrawBalanceAccountHolder(id, value);
        return ResponseEntity.ok(balanceAccountHolderDTO);
    }
}
