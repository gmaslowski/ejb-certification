package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.PrintingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import static com.gmaslowski.security.role.SecurityRoles.ADMIN_ROLE;

@Stateless
@DeclareRoles(ADMIN_ROLE)
@RolesAllowed(ADMIN_ROLE)
public class AdminRoleRequiredPrintingService implements PrintingService {

    private final static Logger log = LoggerFactory.getLogger(AdminRoleRequiredPrintingService.class);

    @EJB(beanName = "PrintingServiceImpl")
    private PrintingService printingService;

    @Override
    public void logRoleInformation() {
        printingService.logRoleInformation();
    }
}
