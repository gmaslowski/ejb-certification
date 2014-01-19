package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.PrintingService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
@RolesAllowed("{admin}")
public class AdminRoleRequiredPrintingService implements PrintingService {

    @EJB(name = "printingServiceImpl")
    private PrintingService printingService;

    @RolesAllowed("{admin}")
    @Override
    public void logRole() {
        printingService.logRole();
    }
}
