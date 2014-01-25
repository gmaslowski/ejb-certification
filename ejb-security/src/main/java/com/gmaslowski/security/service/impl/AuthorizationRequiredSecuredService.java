package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.SecuredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AuthorizationRequiredSecuredService implements SecuredService {

    private final static Logger log = LoggerFactory.getLogger(AuthorizationRequiredSecuredService.class);

    @EJB(beanName = "SecuredServiceImpl")
    private SecuredService securedService;

    @PermitAll
    @Override
    public void logRoleInformation() {
        log.info("Running with @PermitAll");

        securedService.logRoleInformation();
    }
}
