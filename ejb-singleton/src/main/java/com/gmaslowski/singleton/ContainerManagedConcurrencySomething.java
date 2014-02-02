package com.gmaslowski.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Lock;
import javax.ejb.Singleton;

import static com.gmaslowski.singleton.util.ThreadHelper.sleepForMillis;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Singleton
@ConcurrencyManagement(CONTAINER) // also used by default
@Lock(WRITE) // also used by default - will block any concurrent accesses
public class ContainerManagedConcurrencySomething {

    private static final Logger log = LoggerFactory.getLogger(ContainerManagedConcurrencySomething.class);

    private String x = "";
    private String y = "";

    @AccessTimeout(value = 100)
    public void set() {
        x = "X";
        sleepForMillis(200);
        y = "Y";
    }

    @AccessTimeout(value = 100)
    public void reset() {
        x = "";
        sleepForMillis(200);
        y = "";
    }

    @Lock(READ)
    public String getValues() {
        return x + y;
    }
}
