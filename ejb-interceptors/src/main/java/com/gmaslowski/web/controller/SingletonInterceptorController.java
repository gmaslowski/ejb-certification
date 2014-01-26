package com.gmaslowski.web.controller;

import com.gmaslowski.interceptor.Loggable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("/singleton")
@ExcludeDefaultInterceptors
public class SingletonInterceptorController {

    @EJB(beanName = "SingletonService")
    private Loggable singletonService;

    @POST
    public String intercept(String value) {
        singletonService.logMe(value);

        return "OK";
    }

}
