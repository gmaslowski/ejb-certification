package com.gmaslowski.stateful;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
@Asynchronous
public class AsynchronousInvoker {

    @EJB
    StatefulBean statefulBean;

    public void invokeStatelessBean() {
        statefulBean.sayHello();
    }
}
