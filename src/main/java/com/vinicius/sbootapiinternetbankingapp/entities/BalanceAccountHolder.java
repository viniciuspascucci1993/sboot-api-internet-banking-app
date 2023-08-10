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
@Table(name = "tb_balance_account_holder")
public class BalanceAccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_account_holder")
    private String nameAccountHolder;

    @Column(name = "current_balance")
    private BigDecimal currentBalanceAccountHolder;

    @Column(name = "updated_balance")
    private BigDecimal updatedBalanceAccountHolder;

    private String description;
}
