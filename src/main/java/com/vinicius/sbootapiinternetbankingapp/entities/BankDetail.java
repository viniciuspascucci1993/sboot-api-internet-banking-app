package com.vinicius.sbootapiinternetbankingapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_bank_detail")
public class BankDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "code_bank")
    private Integer codeBank;
    private Integer agency;
    private String account;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolder accountHolder;
}
