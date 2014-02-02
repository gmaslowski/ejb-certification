package com.gmaslowski.stateless;

import com.gmaslowski.data.EchoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import static com.gmaslowski.data.EchoData.EchoDataBuilder.echoData;

@Stateless
@LocalBean
public class EchoLocalBean {

    private static final Logger log = LoggerFactory.getLogger(EchoLocalBean.class);

    public void echo(String name) {
        log.info(name);
    }

    public EchoData showEchoData() {
        return echoData().name(EchoLocalBean.class.getCanonicalName()).information("info").build();
    }

}
