package com.token.database.exceptions;

public class CustomerIsUnableToReceiveNewTokens extends Exception {
    public CustomerIsUnableToReceiveNewTokens(String errorMessage) { super(errorMessage); }
}