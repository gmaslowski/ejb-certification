package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.PrintingService;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;

public class AuthorizationRequiredPrintingService implements PrintingService {

    @EJB(name = "printingServiceImpl")
    private PrintingService printingService;

    @PermitAll
    @Override
    public void logRole() {
        printingService.logRole();
    }
}
