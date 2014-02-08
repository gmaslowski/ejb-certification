package com.gmaslowski.exception.application;

// also application exception, has to be defined in throws clause
public class CannotWithdrawException extends Exception {

    public CannotWithdrawException(String message) {
        super(message);
    }
}
