package com.gmaslowski.stateless;

import com.gmaslowski.stateless.view.StatelessLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class StatelessBean implements StatelessLocal {

    private static final Logger log = LoggerFactory.getLogger(StatelessBean.class);

    @Override
    public void ping() {
        log.info("pong");
    }

}
