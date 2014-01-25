package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.PrintingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import static com.gmaslowski.security.role.SecurityRoles.ADMIN_ROLE;

@Stateless
@DeclareRoles(ADMIN_ROLE)
public class PrintingServiceImpl implements PrintingService {

    private final static Logger log = LoggerFactory.getLogger(PrintingServiceImpl.class);

    @Resource
    protected SessionContext ejbContext;

    @Override
    public void logRoleInformation() {
        log.info("principal name - {}", ejbContext.getCallerPrincipal().getName());
        log.info("is caller in role ADMIN - {}", ejbContext.isCallerInRole(ADMIN_ROLE));
    }
}
