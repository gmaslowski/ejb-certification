package com.gmaslowski.exception.system;

// A system exception, which will rollback the
// transaction (CMT) or setRollbackOnly() if transaction started by client (CMT)

// Will discard the ejb.

// Doesn't have to be specified in the throws clause.
public class ConnectionToBankRefusedException extends RuntimeException {
}
