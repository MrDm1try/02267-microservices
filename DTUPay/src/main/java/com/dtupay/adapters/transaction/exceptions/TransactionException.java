package com.dtupay.adapters.transaction.exceptions;

public class TransactionException extends Exception {
    public TransactionException(String errorMessage) {
        super(errorMessage);
    }
}
