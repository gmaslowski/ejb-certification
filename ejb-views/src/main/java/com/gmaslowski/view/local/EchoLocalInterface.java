package com.gmaslowski.view.local;

import com.gmaslowski.data.EchoData;

import javax.ejb.Local;

@Local
public interface EchoLocalInterface {

    void echoLocal(String name);

    EchoData showLocalEchoData();
}
