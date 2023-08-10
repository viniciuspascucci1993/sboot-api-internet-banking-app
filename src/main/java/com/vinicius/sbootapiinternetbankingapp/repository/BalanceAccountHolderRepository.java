package com.vinicius.sbootapiinternetbankingapp.repository;

import com.vinicius.sbootapiinternetbankingapp.entities.BalanceAccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceAccountHolderRepository extends JpaRepository<BalanceAccountHolder, Long> {
}