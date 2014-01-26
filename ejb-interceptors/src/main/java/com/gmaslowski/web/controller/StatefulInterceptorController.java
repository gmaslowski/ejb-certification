package com.gmaslowski.web.controller;

import com.gmaslowski.interceptor.Loggable;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/stateful")
public class StatefulInterceptorController {

    @EJB(beanName = "StatefulService")
    private Loggable statefulService;

    @EJB(beanName = "ExcludeDefaultInterceptorsStatefulService")
    private Loggable excludeDefaultInterceptorsStatefulService;

    @POST
    public String intercept(String value) {
        statefulService.logMe(value);
        excludeDefaultInterceptorsStatefulService.logMe(value);

        return "OK";
    }

}
