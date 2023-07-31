package com.vinicius.sbootapiinternetbankingapp.repository;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
