package com.vinicius.sbootapiinternetbankingapp.repository;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountBankingExtract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingAccountExtractRepository extends JpaRepository<AccountBankingExtract, Long> {
}
