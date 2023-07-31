package com.vinicius.sbootapiinternetbankingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_account_extract")
public class AccountExtract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description_account_extract")
    private String descriptionExtract;

    @OneToMany(mappedBy = "bankAccountDetailing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountBankingExtract> accountBankingExtracts = new ArrayList<>();
}
