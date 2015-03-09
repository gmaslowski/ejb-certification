package com.gmaslowski.singleton.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@DependsOn("StartupFirstSingleton")
@Startup
public class StartupSecondSingleton {

    private static final Logger log = LoggerFactory.getLogger(StartupSecondSingleton.class);

    @PostConstruct
    void postConstruct() {
        log.info("notice when I'm invoked");
    }


    @PreDestroy
    void preDestroy() {
        log.info("notice when I'm invoked");
    }
}
