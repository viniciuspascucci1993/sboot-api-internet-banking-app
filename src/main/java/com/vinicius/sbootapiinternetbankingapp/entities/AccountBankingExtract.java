package com.vinicius.sbootapiinternetbankingapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_banking_extract")
public class AccountBankingExtract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "currrent_date")
    private LocalDate currentDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "balance_current_date")
    private BigDecimal balanceCurrentDate;

    @Column(name = "category_name")
    private String categoryName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "bank_account_detailing_id")
    private BankAccountDetailing bankAccountDetailing;

    @Column(name = "pendency_amount")
    private BigDecimal pendencyAmount;
}
