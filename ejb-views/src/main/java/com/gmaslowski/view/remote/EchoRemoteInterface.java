package com.gmaslowski.view.remote;

import com.gmaslowski.data.EchoData;

import javax.ejb.Remote;

@Remote
public interface EchoRemoteInterface {

    void echoRemote(String name);

    EchoData showRemoteEchoData();
}
