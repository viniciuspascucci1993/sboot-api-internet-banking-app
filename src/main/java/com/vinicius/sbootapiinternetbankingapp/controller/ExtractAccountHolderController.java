package com.vinicius.sbootapiinternetbankingapp.controller;

import com.vinicius.sbootapiinternetbankingapp.dto.AccountExtractDTO;
import com.vinicius.sbootapiinternetbankingapp.service.AccountExtractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/api/v1/internet-banking/extracts")
public class ExtractAccountHolderController {

    @Autowired
    private AccountExtractService accountExtractService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountExtractDTO> listAllCategories(@PathVariable("id") final Long id) {
        return ResponseEntity.ok().body(accountExtractService.findById(id));
    }
}
