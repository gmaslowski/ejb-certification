package com.gmaslowski.web;

import com.gmaslowski.stateless.EchoLocalBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import static com.gmaslowski.ejb.helper.LookupHelpers.DI;

@Stateless
@Path("/no-interface/echo")
public class EchosNoInterfaceController {

    private static final Logger log = LoggerFactory.getLogger(EchosNoInterfaceController.class);

    @EJB
    private EchoLocalBean echoBean;

    @Resource
    private SessionContext sessionContext;

    @GET
    public String echo() {

        EchoLocalBean echoLocalBean;

        log.info("***");

        // CDI - access to all public methods
        echoBean.echo(DI);
        log.info(echoBean.showEchoData().toString());

        log.info("***");

        return "OK";
    }

}
