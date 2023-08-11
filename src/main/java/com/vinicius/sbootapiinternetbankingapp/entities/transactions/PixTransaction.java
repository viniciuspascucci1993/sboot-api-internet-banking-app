package com.vinicius.sbootapiinternetbankingapp.entities.transactions;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pix")
public class PixTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_account")
    private String senderAccount;

    @Column(name = "receiver_account")
    private String receiverAccount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private BigDecimal amount;
}
