package com.gmaslowski.stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import static java.lang.Thread.currentThread;

@Stateless
@LocalBean
public class StatelessBean {

    private static final Logger log = LoggerFactory.getLogger(StatelessBean.class);

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
