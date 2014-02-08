package com.gmaslowski.exception.application;

import javax.ejb.ApplicationException;

// is app exceptions, even if runtime
@ApplicationException(rollback = true) // will rollback the transaction
// or will setRollbackOnly() (if client transaction)
public class NoCashOnAccountException extends RuntimeException {

    public NoCashOnAccountException(String message) {
        super(message);
    }
}
