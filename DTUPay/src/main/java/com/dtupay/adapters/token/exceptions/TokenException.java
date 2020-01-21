package com.dtupay.adapters.token.exceptions;

/**
 * @author Dumitru
 *
 * exception class used in token adapter
 */
public class TokenException extends Exception {
    public TokenException(String errorMessage) {
        super(errorMessage);
    }
}
