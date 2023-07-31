package com.vinicius.sbootapiinternetbankingapp.controller;

import com.vinicius.sbootapiinternetbankingapp.dto.AccountHolderPostDTO;
import com.vinicius.sbootapiinternetbankingapp.dto.AccountHolderGetDTO;
import com.vinicius.sbootapiinternetbankingapp.service.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/internet-banking/account-holders")
public class AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

    @PostMapping
    public ResponseEntity<AccountHolderPostDTO> insert(@Valid @RequestBody AccountHolderPostDTO accountHolderPostDTO) {

        accountHolderPostDTO = accountHolderService.insert(accountHolderPostDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(accountHolderPostDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(accountHolderPostDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountHolderGetDTO> listAllCategories(@PathVariable("id") final Long id) {
        return ResponseEntity.ok().body(accountHolderService.findById(id));
    }
}
