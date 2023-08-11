package com.vinicius.sbootapiinternetbankingapp.dto.transactions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PixTransactionDTO {

    private Long id;
    private String senderAccount;
    private String receiverAccount;
    private LocalDate date;
    private BigDecimal amount;
}
