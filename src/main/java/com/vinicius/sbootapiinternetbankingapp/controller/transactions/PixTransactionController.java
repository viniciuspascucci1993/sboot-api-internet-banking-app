package com.vinicius.sbootapiinternetbankingapp.controller.transactions;

import com.vinicius.sbootapiinternetbankingapp.entities.transactions.PixTransaction;
import com.vinicius.sbootapiinternetbankingapp.service.transactions.CallerSmsPixNotificationServuce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/internet-banking/pix")
public class PixTransactionController {

    @Autowired
    private CallerSmsPixNotificationServuce callerSmsPixNotificationServuce;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody PixTransaction pixTransaction) {
        callerSmsPixNotificationServuce.sendSms(pixTransaction.getId());
        return ResponseEntity.ok("Transferência Pix Realizada com sucesso");
    }
}
