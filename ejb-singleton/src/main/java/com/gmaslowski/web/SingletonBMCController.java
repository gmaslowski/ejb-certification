package com.gmaslowski.web;

import com.gmaslowski.singleton.util.AsynchronousBeanSetter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/singleton/bean")
public class SingletonBMCController {

    public static final int TEN_THOUSAND_TIMES = 10000;

    @EJB
    private AsynchronousBeanSetter setter;

    @GET
    public String start() {
        setter.setTimes(TEN_THOUSAND_TIMES);
        setter.resetTimes(TEN_THOUSAND_TIMES);

        setter.start();

        return "OK";
    }
}
