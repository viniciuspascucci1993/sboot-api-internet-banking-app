package com.vinicius.sbootapiinternetbankingapp.service;

import com.vinicius.sbootapiinternetbankingapp.dto.BalanceAccountHolderDTO;
import com.vinicius.sbootapiinternetbankingapp.entities.BalanceAccountHolder;
import com.vinicius.sbootapiinternetbankingapp.repository.BalanceAccountHolderRepository;
import com.vinicius.sbootapiinternetbankingapp.service.exceptions.InvalidDepositException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BalanceAccountHolderService {

    @Autowired
    private BalanceAccountHolderRepository balanceAccountHolderRepository;

    public BalanceAccountHolderDTO getDepositValue(long id, Double depositValue) {

        BalanceAccountHolder balanceAccountHolder = balanceAccountHolderRepository.findById(id).get();

        if (depositValue > 0) {
            balanceAccountHolder.setCurrentBalanceAccountHolder(balanceAccountHolder.getCurrentBalanceAccountHolder().
                    add(new BigDecimal(depositValue)));
            balanceAccountHolder.setDescription("Seu deposito foi realizado com sucesso!");
        } else {
            throw new InvalidDepositException("Não foi possível realizar o deposito");
        }
        return mapBalanceAccountHolderToBalanceAccountHolderDTO(balanceAccountHolder);

    }

    public BalanceAccountHolderDTO getWithDrawBalanceAccountHolder(Long id, Double value) {

        BalanceAccountHolder balanceAccountHolder = balanceAccountHolderRepository.findById(id).get();

        if (value <= 100) {
            balanceAccountHolder.setDescription("Valor abaixo de 100.00, Isento de Taxa de saque!!");

        } else if (value > 100 && value <= 300) {
            BigDecimal actualBalance =
                    calcularDesconto(value, balanceAccountHolder.getCurrentBalanceAccountHolder(), 0.4);
            balanceAccountHolder.setUpdatedBalanceAccountHolder(actualBalance);
            balanceAccountHolder.setDescription("O Correntista: " + balanceAccountHolder.getNameAccountHolder() +
                    " Deverá pagar uma Taxa de 0.4%");

        } else if (value > 300) {
            BigDecimal actualBalance =
                    calcularDesconto(value, balanceAccountHolder.getCurrentBalanceAccountHolder(), 1);
            balanceAccountHolder.setUpdatedBalanceAccountHolder(actualBalance);
            balanceAccountHolder.setDescription("O Correntista: " + balanceAccountHolder.getNameAccountHolder() +
                    " Deverá pagar uma Taxa de 1%");
        } else {
            return null;
        }

        return mapBalanceAccountHolderToBalanceAccountHolderDTO(balanceAccountHolder);
     }

    private BalanceAccountHolderDTO mapBalanceAccountHolderToBalanceAccountHolderDTO(BalanceAccountHolder balanceAccountHolder) {

        BalanceAccountHolderDTO balanceAccountHolderDTO = new BalanceAccountHolderDTO();
        balanceAccountHolderDTO.setId(balanceAccountHolder.getId());
        balanceAccountHolderDTO.setNameAccountHolder(balanceAccountHolder.getNameAccountHolder());
        balanceAccountHolderDTO.setCurrentBalanceAccountHolder(balanceAccountHolder.getCurrentBalanceAccountHolder());
        balanceAccountHolderDTO.setUpdatedBalanceAccountHolder(balanceAccountHolder.getUpdatedBalanceAccountHolder());
        balanceAccountHolderDTO.setDescription(balanceAccountHolder.getDescription());

        return balanceAccountHolderDTO;

    }

    private static BigDecimal calcularDesconto(double valorDeSaque, BigDecimal saldoConta, double percentualDesconto) {
        BigDecimal valorSaque = BigDecimal.valueOf(valorDeSaque);
        BigDecimal percentual = valorSaque.multiply(BigDecimal.valueOf(percentualDesconto));
        // valor de desconto
        BigDecimal valorDesconto = percentual.divide(new BigDecimal(100));
        valorDesconto = valorDesconto.setScale(2, RoundingMode.HALF_EVEN);
        valorDesconto = valorDesconto.add(valorSaque);

        BigDecimal resultado = saldoConta.subtract(valorDesconto);
        return resultado;
    }
}
