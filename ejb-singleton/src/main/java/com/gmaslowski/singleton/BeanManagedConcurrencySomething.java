package com.gmaslowski.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;

import static com.gmaslowski.singleton.util.ThreadHelper.sleepForMillis;
import static javax.ejb.ConcurrencyManagementType.BEAN;

@Singleton
@ConcurrencyManagement(BEAN) // now all the needed locking and synchronization is on the dev responsibility
// should use any java synchronization techniques
// if not, like in this example - see what's happening ;)
public class BeanManagedConcurrencySomething {

    private static final Logger log = LoggerFactory.getLogger(BeanManagedConcurrencySomething.class);

    private String x = "";
    private String y = "";

    public void set() {
        x = "X";
        sleepForMillis(200);
        y = "Y";
    }

    public void reset() {
        x = "";
        sleepForMillis(200);
        y = "";
    }

    public String getValues() {
        return x + y;
    }
}
