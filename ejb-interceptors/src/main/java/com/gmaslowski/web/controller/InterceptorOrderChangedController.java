package com.gmaslowski.web.controller;

import com.gmaslowski.interceptor.order.OrderChangedLoggable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("/order")
public class InterceptorOrderChangedController {

    @EJB(beanName = "InterceptorOrderChangedService")
    private OrderChangedLoggable interceptorOrderChangedService;

    @POST
    public String intercept(String value) {
        interceptorOrderChangedService.logMe(value);
        interceptorOrderChangedService.logMeWithChangedOrder(value);

        return "OK";
    }

}
