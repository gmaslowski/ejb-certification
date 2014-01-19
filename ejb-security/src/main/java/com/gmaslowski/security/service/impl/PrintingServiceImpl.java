package com.gmaslowski.security.service.impl;

import com.gmaslowski.security.service.PrintingService;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.security.Principal;
import java.util.logging.Logger;

import static java.lang.String.valueOf;

@Stateless
public class PrintingServiceImpl implements PrintingService {

    private final static Logger log = Logger.getLogger(valueOf(PrintingServiceImpl.class));

    @Resource
    protected SessionContext ejbContext;

    @Override
    public void logRole() {
        Principal principal = ejbContext.getCallerPrincipal();
    }
}
