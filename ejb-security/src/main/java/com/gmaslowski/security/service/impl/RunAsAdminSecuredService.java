package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.SecuredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;

import static com.gmaslowski.security.role.SecurityRoles.ADMIN_ROLE;

@RunAs(ADMIN_ROLE)
@Stateless
public class RunAsAdminSecuredService implements SecuredService {

    private static final Logger log = LoggerFactory.getLogger(RunAsAdminSecuredService.class);

    @EJB(beanName = "AdminRoleRequiredSecuredService")
    private SecuredService securedService;

    @Resource
    private EJBContext ejbContext;

    @Override
    public void logRoleInformation() {
        log.info("I am a {}, but I'm running a ADMIN required method by using @RunAs.", ejbContext.getCallerPrincipal().getName());
        securedService.logRoleInformation();
    }
}
