package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.SecuredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import static com.gmaslowski.security.role.SecurityRoles.ADMIN_ROLE;
import static com.gmaslowski.security.role.SecurityRoles.ALL_ROLES;

@Stateless
@DeclareRoles(ADMIN_ROLE)
public class SecuredServiceImpl implements SecuredService {

    private final static Logger log = LoggerFactory.getLogger(SecuredServiceImpl.class);

    @Resource
    protected SessionContext ejbContext;

    @Override
    public void logRoleInformation() {
        log.info("principal name - {}", ejbContext.getCallerPrincipal().getName());

        for (String role : ALL_ROLES) {
            log.info("is caller in role {} - {}", role, ejbContext.isCallerInRole(role));
        }
    }
}
