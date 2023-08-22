package com.vinicius.sbootapiinternetbankingapp.controller;

import com.vinicius.sbootapiinternetbankingapp.dto.AccountHolderDTO;
import com.vinicius.sbootapiinternetbankingapp.service.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/internet-banking/account-holders")
public class AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountHolderDTO> findById(@PathVariable("id") Long id ) {

        AccountHolderDTO dto = accountHolderService.findById( id );
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<AccountHolderDTO> insert(@Valid @RequestBody AccountHolderDTO accountHolderDTO) {

        accountHolderDTO = accountHolderService.insert(accountHolderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(accountHolderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(accountHolderDTO);
    }
}
