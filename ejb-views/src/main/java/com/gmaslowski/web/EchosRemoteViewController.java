package com.gmaslowski.web;

import com.gmaslowski.view.EchoInterface;
import com.gmaslowski.view.remote.EchoRemoteInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import static com.gmaslowski.ejb.helper.LookupHelpers.DI;
import static com.gmaslowski.ejb.helper.LookupHelpers.INITIAL_CONTEXT_LOOKUP;
import static com.gmaslowski.ejb.helper.LookupHelpers.SESSION_CTX_LOOKUP;
import static com.gmaslowski.ejb.helper.LookupHelpers.initialContextLookup;
import static com.gmaslowski.ejb.helper.LookupHelpers.sessionContextLookup;

@Stateless
@Path("/remote/echo")
public class EchosRemoteViewController {

    private static final Logger log = LoggerFactory.getLogger(EchosRemoteViewController.class);

    @EJB(name = "EchoBeanRemote")
    private EchoRemoteInterface echoBeanByDI;

    @EJB(name = "EchoAnnotatedBeanRemote")
    private EchoInterface echoAnnotatedBeanByDI; // echoInterface is both @Local and @Remote
    // observe the results

    @Resource
    private SessionContext sessionContext;

    @GET
    public String echo() {
        EchoRemoteInterface echoBean = null;
        EchoInterface echoAnnotatedBean = null;

        log.info("***");

        // CDI
        echoBeanByDI.echoRemote(DI);
        log.info(echoBeanByDI.showRemoteEchoData().toString());

        echoAnnotatedBeanByDI.echo(DI);
        log.info(echoAnnotatedBeanByDI.showEchoData().toString());

        log.info("***");

        // SessionContextLookup
        echoBean = sessionContextLookup(sessionContext, "EchoBeanRemote");
        echoAnnotatedBean = sessionContextLookup(sessionContext, "EchoAnnotatedBeanRemote");

        echoBean.echoRemote(SESSION_CTX_LOOKUP);
        log.info(echoBean.showRemoteEchoData().toString());

        echoAnnotatedBean.echo(SESSION_CTX_LOOKUP);
        log.info(echoAnnotatedBean.showEchoData().toString());

        log.info("***");

        // initial context lookup looks like it's container-specific
        echoBean = initialContextLookup("java:global/ejb-views/EchoBean!com.gmaslowski.view.remote.EchoRemoteInterface");
        echoAnnotatedBean = initialContextLookup("java:global/ejb-views/EchoAnnotatedBean!com.gmaslowski.view.EchoInterface");

        echoBean.echoRemote(INITIAL_CONTEXT_LOOKUP);
        log.info(echoBean.showRemoteEchoData().toString());

        echoAnnotatedBean.echo(INITIAL_CONTEXT_LOOKUP);
        log.info(echoAnnotatedBean.showEchoData().toString());

        log.info("***");

        return "OK";
    }
}
