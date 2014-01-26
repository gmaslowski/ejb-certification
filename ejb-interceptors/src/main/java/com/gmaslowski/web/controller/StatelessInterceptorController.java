package com.gmaslowski.web.controller;

import com.gmaslowski.interceptor.stateless.Loggable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/interceptor")
@Stateless
public class StatelessInterceptorController {

    @EJB(beanName = "StatelessService")
    private Loggable statelessService;

    @EJB(beanName = "ExcludeDefaultInterceptorsStatelessService")
    private Loggable excludeDefaultInterceptorsStatelessService;

    @EJB(beanName = "ExcludeClassInterceptorsStatelessService")
    private Loggable excludeClassInterceptorsStatelessService;

    @POST
    @Path("/stateless")
    public String intercept(String value) {
        statelessService.logMe(value);
        excludeDefaultInterceptorsStatelessService.logMe(value);
        excludeClassInterceptorsStatelessService.logMe(value);

        return "OK";
    }
}
