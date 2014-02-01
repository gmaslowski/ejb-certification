package com.gmaslowski.view.remote;

import javax.ejb.Remote;

@Remote
public interface EchoRemoteInterface {

    void echoRemote(String name);
}
