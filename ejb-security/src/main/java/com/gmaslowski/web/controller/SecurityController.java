package com.gmaslowski.web.controller;

import com.gmaslowski.security.service.SecuredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/security")
public class SecurityController {

    private static final Logger log = LoggerFactory.getLogger(SecurityController.class);

    @EJB(beanName = "SecuredServiceImpl")
    private SecuredService defaultSecuredService;

    @EJB(beanName = "AdminRoleRequiredSecuredService")
    private SecuredService adminRoleRequiredSecuredService;

    @EJB(beanName = "AuthorizationRequiredSecuredService")
    private SecuredService authorizationRequiredSecuredService;

    @EJB(beanName = "RunAsAdminSecuredService")
    private SecuredService runAsAdminSecuredService;


    @GET
    public String security() {
        tryToLogRoleInformation(defaultSecuredService);
        tryToLogRoleInformation(authorizationRequiredSecuredService);
        tryToLogRoleInformation(adminRoleRequiredSecuredService);
        tryToLogRoleInformation(runAsAdminSecuredService);

        return "OK";
    }

    private void tryToLogRoleInformation(SecuredService securedService) {
        log.info("Invoking {}", securedService.toString());
        try {
            securedService.logRoleInformation();
        } catch (EJBAccessException ejbae) {
            log.warn("EJBAccesException: {}", ejbae.getMessage());
        }
    }


}