package com.gmaslowski.web;

import com.gmaslowski.view.EchoInterface;
import com.gmaslowski.view.local.EchoLocalInterface;
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
@Path("/local/echo")
public class EchosLocalViewController {

    private static final Logger log = LoggerFactory.getLogger(EchosLocalViewController.class);

    @EJB(name = "ejb/EchoBean")
    private EchoLocalInterface echoBeanByDI;

    @EJB(name = "ejb/EchoAnnotatedBean")
    private EchoInterface echoAnnotatedBeanByDI; // echoInterface is both @Local and @Remote
    // observe the results

    @Resource
    private SessionContext sessionContext;

    @GET
    public String echo() {
        EchoLocalInterface echoBean = null;
        EchoInterface echoAnnotatedBean = null;

        log.info("***");

        // CDI
        echoBeanByDI.echoLocal(DI);
        log.info(echoBeanByDI.showLocalEchoData().toString());

        echoAnnotatedBeanByDI.echo(DI);
        log.info(echoAnnotatedBeanByDI.showEchoData().toString());

        log.info("***");

        // SessionContextLookup
        echoBean = sessionContextLookup(sessionContext, "ejb/EchoBean");
        echoAnnotatedBean = sessionContextLookup(sessionContext, "ejb/EchoAnnotatedBean");

        echoBean.echoLocal(SESSION_CTX_LOOKUP);
        log.info(echoBean.showLocalEchoData().toString());

        echoAnnotatedBean.echo(SESSION_CTX_LOOKUP);
        log.info(echoAnnotatedBean.showEchoData().toString());

        log.info("***");

        // initial context lookup looks like it's container-specific
        echoBean = initialContextLookup("java:global/ejb-views/EchoBean!com.gmaslowski.view.local.EchoLocalInterface");
        echoAnnotatedBean = initialContextLookup("java:global/ejb-views/EchoAnnotatedBean!com.gmaslowski.view.EchoInterface");

        echoBean.echoLocal(INITIAL_CONTEXT_LOOKUP);
        log.info(echoBean.showLocalEchoData().toString());

        echoAnnotatedBean.echo(INITIAL_CONTEXT_LOOKUP);
        log.info(echoAnnotatedBean.showEchoData().toString());

        log.info("***");

        return "OK";
    }
}
