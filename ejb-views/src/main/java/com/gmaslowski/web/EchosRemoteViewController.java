package com.gmaslowski.web;

import com.gmaslowski.view.EchoInterface;
import com.gmaslowski.view.remote.EchoRemoteInterface;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("/remote/echo")
public class EchosRemoteViewController {

    public static final String DI = "_DependencyInjection";
    public static final String SESSION_CTX_LOOKUP = "_SessionCtxLookup";
    public static final String INITIAL_CONTEXT_LOOKUP = "_InitialContextLookup";

    @EJB(name = "ejb/EchoBean")
    private EchoRemoteInterface echoBeanByDI;

    @EJB(name = "ejb/EchoAnnotatedBean")
    private EchoInterface echoAnnotatedBeanByDI;

    @Resource
    private SessionContext sessionContext;

    @GET
    public String echo() {
        echoBeanByDI.echoRemote(DI);
        echoAnnotatedBeanByDI.echo(DI);

        echoBySessionContextLookup(SESSION_CTX_LOOKUP);
        echoAnnotatedBeanBySessionContextLookup(SESSION_CTX_LOOKUP);

        echoBeanByInitialContextLookup(INITIAL_CONTEXT_LOOKUP);
        echoAnnotatedBeanByInitialContextLookup(INITIAL_CONTEXT_LOOKUP);

        return "OK";
    }

    private void echoAnnotatedBeanBySessionContextLookup(String name) {
        ((EchoInterface) sessionContext.lookup("ejb/EchoAnnotatedBean")).echo(name);
    }

    private void echoBySessionContextLookup(String name) {
        ((EchoRemoteInterface) sessionContext.lookup("ejb/EchoBean")).echoRemote(name);
    }

    private void echoAnnotatedBeanByInitialContextLookup(String name) {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            EchoInterface i = (EchoInterface) ctx.lookup("java:global/ejb-views/EchoAnnotatedBean");
            i.echo(name);
        } catch (NamingException swallowForExample) {
        }
    }

    private void echoBeanByInitialContextLookup(String name) {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            EchoRemoteInterface i = (EchoRemoteInterface) ctx.lookup("java:global/ejb-views/EchoBeanRemote");
            i.echoRemote(name);
        } catch (NamingException swallowForExample) {
        }
    }
}
