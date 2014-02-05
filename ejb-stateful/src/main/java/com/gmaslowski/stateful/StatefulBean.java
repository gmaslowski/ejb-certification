package com.gmaslowski.stateful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import static java.lang.Thread.currentThread;

@Stateful
@LocalBean
public class StatefulBean {

    private static final Logger log = LoggerFactory.getLogger(StatefulBean.class);

    private static int instanceNumber = 0;

    private int currentInstanceNumber;

    @PostConstruct
    void init() {
        currentInstanceNumber = ++instanceNumber;
        log.info("Instance number: " + currentInstanceNumber);
    }

    public void sayHello() {
        log.info("{} instance {} says: hello.", currentThread().getName(), currentInstanceNumber);
    }


}
