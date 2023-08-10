package com.vinicius.sbootapiinternetbankingapp.service.exceptions;

public class InvalidDepositException extends RuntimeException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public InvalidDepositException(String message) {
        super(message);
    }
}
