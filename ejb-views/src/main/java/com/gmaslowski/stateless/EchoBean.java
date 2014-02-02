package com.gmaslowski.stateless;

import com.gmaslowski.data.EchoData;
import com.gmaslowski.view.local.EchoLocalInterface;
import com.gmaslowski.view.remote.EchoRemoteInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

import static com.gmaslowski.data.EchoData.EchoDataBuilder.echoData;

@Stateless
public class EchoBean implements EchoRemoteInterface, EchoLocalInterface {

    private static final Logger log = LoggerFactory.getLogger(EchoBean.class);

    @Override
    public void echoLocal(String name) {
        log.info("[{}] call from local interface", name);
    }

    @Override
    public EchoData showLocalEchoData() {
        return echoData().name(EchoBean.class.getCanonicalName()).information("call from local interface").build();
    }

    @Override
    public void echoRemote(String name) {
        log.info("[{}] call from remote interface", name);
    }

    @Override
    public EchoData showRemoteEchoData() {
        return echoData().name(EchoBean.class.getCanonicalName()).information("call from remote interface").build();
    }
}
