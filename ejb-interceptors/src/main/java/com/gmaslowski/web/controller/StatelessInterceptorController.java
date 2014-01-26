package com.gmaslowski.web.controller;


import com.gmaslowski.interceptor.Loggable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("/stateless")
@ExcludeDefaultInterceptors
public class StatelessInterceptorController {

    @EJB(beanName = "StatelessService")
    private Loggable statelessService;

    @EJB(beanName = "ExcludeDefaultInterceptorsStatelessService")
    private Loggable excludeDefaultInterceptorsStatelessService;

    @EJB(beanName = "ExcludeClassInterceptorsStatelessService")
    private Loggable excludeClassInterceptorsStatelessService;

    @POST
    public String intercept(String value) {
        statelessService.logMe(value);
        excludeDefaultInterceptorsStatelessService.logMe(value);
        excludeClassInterceptorsStatelessService.logMe(value);

        return "OK";
    }
}
