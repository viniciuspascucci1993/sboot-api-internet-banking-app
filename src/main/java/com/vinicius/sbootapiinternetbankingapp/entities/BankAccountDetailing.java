package com.vinicius.sbootapiinternetbankingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_banking_account")
public class BankAccountDetailing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name_account_holder")
    private String fullNameAccountHolder;

    @Column(name = "number_bank")
    private Integer numberBank;

    @Column(name = "number_bank_account")
    private Long numberBankAccount;

    @Column(name = "cpf_cnpj_account_holder")
    private Long cpfOrCnpjAccountHolder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_data_id")
    private ContactData contactData;

    @OneToMany(mappedBy = "bankAccountDetailing", cascade = CascadeType.ALL)
    private List<AccountBankingExtract> accountBankingExtracts;

    @Column(name = "balance_account")
    private BigDecimal balanceAccount;

    @OneToMany(mappedBy = "bankDetailingAccount", cascade = CascadeType.ALL)
    private List<BankCardData> bankCardDataList;

    @Column(name = "password_or_acces_code")
    private Long passwordOrAccesCode;
}
