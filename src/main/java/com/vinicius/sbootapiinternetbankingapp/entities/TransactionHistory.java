package com.vinicius.sbootapiinternetbankingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_transaction_history")
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "financial_activity")
    private String financialActivity;

    @OneToMany(mappedBy = "bankAccountDetailing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountBankingExtract> accountBankingExtracts;
}
