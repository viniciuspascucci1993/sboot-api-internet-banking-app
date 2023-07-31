package com.vinicius.sbootapiinternetbankingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_bank_card")
public class BankCardData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "flag_credit_card")
    private String flagCreditCard;
    @Column(name = "type_credit_card")
    private String typeCreditCard;
    @Column(name = "limit_credit_card")
    private BigDecimal limitCreditCard;

    @ManyToOne
    @JoinColumn(name = "banking_account_id")
    private BankAccountDetailing bankDetailingAccount;
}
