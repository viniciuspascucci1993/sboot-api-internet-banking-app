package com.vinicius.sbootapiinternetbankingapp.repository;

import com.vinicius.sbootapiinternetbankingapp.entities.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailRepository extends JpaRepository<BankDetail, Long> {
}
