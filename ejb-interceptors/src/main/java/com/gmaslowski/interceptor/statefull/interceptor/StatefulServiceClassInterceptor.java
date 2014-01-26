package com.gmaslowski.interceptor.statefull.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.enterprise.inject.spi.InterceptionType.AROUND_INVOKE;
import static javax.enterprise.inject.spi.InterceptionType.POST_ACTIVATE;
import static javax.enterprise.inject.spi.InterceptionType.POST_CONSTRUCT;
import static javax.enterprise.inject.spi.InterceptionType.PRE_DESTROY;
import static javax.enterprise.inject.spi.InterceptionType.PRE_PASSIVATE;

@Interceptor
public class StatefulServiceClassInterceptor implements StatefulServiceInterceptor {

    private static final Logger log = LoggerFactory.getLogger(StatefulServiceClassInterceptor.class);

    @PostActivate
    @Override
    public void postActivateIntercept(InvocationContext invocationContext) {
        log.info(POST_ACTIVATE.toString() + " on " + invocationContext.getTarget().getClass());
    }

    @PrePassivate
    @Override
    public void prePassivateIntercept(InvocationContext invocationContext) {
        log.info(PRE_PASSIVATE.toString() + " on " + invocationContext.getTarget().getClass());
    }

    @PostConstruct
    @Override
    public void postConstructIntercept(InvocationContext invocationContext) {
        log.info(POST_CONSTRUCT.toString() + " on " + invocationContext.getTarget().getClass());
    }

    @PreDestroy
    @Override
    public void preDestroyIntercept(InvocationContext invocationContext) {
        log.info(PRE_DESTROY.toString() + " on " + invocationContext.getTarget().getClass());
    }

    @AroundInvoke
    @Override
    public Object aroundInvokeIntercept(InvocationContext invocationContext) throws Exception {
        log.info(AROUND_INVOKE.toString() + " on " + invocationContext.getTarget().getClass());
        return invocationContext.proceed();
    }
}
