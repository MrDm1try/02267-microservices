package com.merchant.database.exceptions;

public class TokenAlreadyUsed extends Exception {
    public TokenAlreadyUsed(String errorMessage) {
        super(errorMessage);
    }
}
