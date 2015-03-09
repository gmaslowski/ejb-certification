package com.gmaslowski.singleton.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

@Singleton
// I'm intentionally not annotating this with @Startup, lets see what the container will do
public class StartupFirstSingleton {

    private static final Logger log = LoggerFactory.getLogger(StartupFirstSingleton.class);

    @PostConstruct
    void postConstruct() {
        log.info("notice when I'm invoked");
    }


    @PreDestroy
    void preDestroy() {
        log.info("notice when I'm invoked");
    }
}
