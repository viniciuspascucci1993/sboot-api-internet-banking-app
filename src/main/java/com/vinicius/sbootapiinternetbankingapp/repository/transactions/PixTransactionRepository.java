package com.vinicius.sbootapiinternetbankingapp.repository.transactions;

import com.vinicius.sbootapiinternetbankingapp.entities.transactions.PixTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixTransactionRepository extends JpaRepository<PixTransaction, Long> {
}
