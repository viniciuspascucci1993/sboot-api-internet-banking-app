package com.vinicius.sbootapiinternetbankingapp.repository;

import com.vinicius.sbootapiinternetbankingapp.entities.AccountExtract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountExtractRepository extends JpaRepository<AccountExtract, Long> {
}
