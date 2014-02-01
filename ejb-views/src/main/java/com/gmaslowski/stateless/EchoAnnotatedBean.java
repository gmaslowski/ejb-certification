package com.gmaslowski.stateless;

import com.gmaslowski.view.EchoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(EchoInterface.class)
@Local(EchoInterface.class)
public class EchoAnnotatedBean implements EchoInterface {

    private static final Logger log = LoggerFactory.getLogger(EchoAnnotatedBean.class);

    @Override
    public void echo(String name) {
        log.info("[{}] cannot tell which interface, since the same interface is used as local and remote", name);
    }
}
