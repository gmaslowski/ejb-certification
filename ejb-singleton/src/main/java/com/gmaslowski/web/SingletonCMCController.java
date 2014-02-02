package com.gmaslowski.web;

import com.gmaslowski.singleton.util.AsynchronousContainerSetter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/singleton/container")
public class SingletonCMCController {

    public static final int TEN_THOUSAND_TIMES = 10000;

    @EJB
    private AsynchronousContainerSetter setter;

    @GET
    public String start() {
        setter.setTimes(TEN_THOUSAND_TIMES);
        setter.resetTimes(TEN_THOUSAND_TIMES);

        setter.start();

        return "OK";
    }
}
