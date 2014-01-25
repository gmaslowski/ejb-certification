package com.gmaslowski.web.controller;

import com.gmaslowski.security.service.PrintingService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/security")
public class SecurityController {

    @EJB(beanName = "PrintingServiceImpl")
    private PrintingService defaultPrintingService;

    @EJB(beanName = "AdminRoleRequiredPrintingService")
    private PrintingService adminRoleRequiredPrintingService;

    @EJB(beanName = "AuthorizationRequiredPrintingService")
    private PrintingService authorizationRequiredPrintingService;

    @GET
    public String security() {
        defaultPrintingService.logRoleInformation();
        adminRoleRequiredPrintingService.logRoleInformation();
        authorizationRequiredPrintingService.logRoleInformation();

        return "OK";
    }


}
