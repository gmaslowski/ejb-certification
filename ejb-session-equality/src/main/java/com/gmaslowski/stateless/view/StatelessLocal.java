package com.gmaslowski.stateless.view;

import javax.ejb.Local;

@Local
public interface StatelessLocal {
    void ping();
}
