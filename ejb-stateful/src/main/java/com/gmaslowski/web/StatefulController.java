package com.gmaslowski.web;

import com.gmaslowski.stateful.AsynchronousInvoker;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/stateful")
public class StatefulController {

    public static final int INVOKING_COUNT = 1000;
    @EJB
    AsynchronousInvoker invoker;

    @GET
    public String start() {

        for (int i = 0; i < INVOKING_COUNT; i++) {
            invoker.invokeStatelessBean();
        }

        return "OK";
    }
}
