package com.gmaslowski.stateless;

import com.gmaslowski.view.local.EchoLocalInterface;
import com.gmaslowski.view.remote.EchoRemoteInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class EchoBean implements EchoRemoteInterface, EchoLocalInterface {

    private static final Logger log = LoggerFactory.getLogger(EchoBean.class);

    @Override
    public void localCall(String name) {
        log.info("[{}] call from local interface", name);
    }

    @Override
    public void echoRemote(String name) {
        log.info("[{}] call from remote interface", name);
    }
}
