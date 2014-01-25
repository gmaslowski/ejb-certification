package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.SecuredService;
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
public class AdminRoleRequiredSecuredService implements SecuredService {

    private final static Logger log = LoggerFactory.getLogger(AdminRoleRequiredSecuredService.class);

    @EJB(beanName = "SecuredServiceImpl")
    private SecuredService securedService;

    @Override
    public void logRoleInformation() {
        securedService.logRoleInformation();
    }
}
