package com.gmaslowski.stateless;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
@Asynchronous
public class AsynchronousInvoker {

    @EJB
    StatelessBean statelessBean;

    public void invokeStatelessBean() {
        statelessBean.sayHello();
    }
}
