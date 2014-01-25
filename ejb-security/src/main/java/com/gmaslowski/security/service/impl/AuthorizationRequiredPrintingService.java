package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.PrintingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AuthorizationRequiredPrintingService implements PrintingService {

    private final static Logger log = LoggerFactory.getLogger(AuthorizationRequiredPrintingService.class);

    @EJB(beanName = "PrintingServiceImpl")
    private PrintingService printingService;

    @PermitAll
    @Override
    public void logRoleInformation() {
        log.info("Running with @PermitAll");

        printingService.logRoleInformation();
    }
}
