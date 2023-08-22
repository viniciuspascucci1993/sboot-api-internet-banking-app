package com.vinicius.sbootapiinternetbankingapp.controller.transactions;

import com.vinicius.sbootapiinternetbankingapp.entities.transactions.PixTransaction;
import com.vinicius.sbootapiinternetbankingapp.service.transactions.CallerSmsPixNotificationServuce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/internet-banking/pix")
public class PixTransactionController {

    @Autowired
    private CallerSmsPixNotificationServuce callerSmsPixNotificationServuce;

    @PostMapping("/transfer/{valueTransfer}")
    public ResponseEntity<String> transfer(@RequestBody PixTransaction pixTransaction,
                    @PathVariable("valueTransfer") BigDecimal valueTransfer) {
        callerSmsPixNotificationServuce.sendSms(pixTransaction.getId(), valueTransfer);
        return ResponseEntity.ok("Transferência Pix Realizada com sucesso");
    }
}
