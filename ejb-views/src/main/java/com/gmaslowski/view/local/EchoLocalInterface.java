package com.gmaslowski.view.local;

import javax.ejb.Local;

@Local
public interface EchoLocalInterface {

    void localCall(String name);
}
