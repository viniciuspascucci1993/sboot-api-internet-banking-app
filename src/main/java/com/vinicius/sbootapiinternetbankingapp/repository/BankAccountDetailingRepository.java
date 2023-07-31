package com.vinicius.sbootapiinternetbankingapp.repository;

import com.vinicius.sbootapiinternetbankingapp.dto.BankAccountDetailingDTO;
import com.vinicius.sbootapiinternetbankingapp.entities.BankAccountDetailing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountDetailingRepository extends JpaRepository<BankAccountDetailing, Long> {

    @Query("SELECT bd " +
            "FROM BankAccountDetailing bd " +
            "LEFT JOIN bd.contactData " +
            "LEFT JOIN bd.accountBankingExtracts " +
            "LEFT JOIN bd.bankCardDataList " +
            "WHERE bd.id = :id")
    BankAccountDetailingDTO getBankAccountDetailingDTOById(@Param("id") Long id);

}
