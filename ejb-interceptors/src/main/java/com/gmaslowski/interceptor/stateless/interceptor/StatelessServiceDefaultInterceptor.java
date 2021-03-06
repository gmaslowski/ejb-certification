package com.gmaslowski.interceptor.stateless.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import static com.google.common.base.Joiner.on;
import static javax.enterprise.inject.spi.InterceptionType.AROUND_INVOKE;
import static javax.enterprise.inject.spi.InterceptionType.POST_CONSTRUCT;
import static javax.enterprise.inject.spi.InterceptionType.PRE_DESTROY;

public class StatelessServiceDefaultInterceptor implements StatelessServiceInterceptor {

    private static final Logger log = LoggerFactory.getLogger(StatelessServiceDefaultInterceptor.class);

    @PostConstruct
    @Override
    public void postConstructIntercept(InvocationContext invocationContext) throws Exception {
        log.info(POST_CONSTRUCT.toString() + " on " + invocationContext.getTarget().getClass());
        invocationContext.proceed();
    }

    @PreDestroy
    @Override
    public void preDestroyIntercept(InvocationContext invocationContext) throws Exception {
        log.info(PRE_DESTROY.toString());
        invocationContext.proceed();
    }

    @AroundInvoke
    @Override
    public Object aroundInvokeIntercept(InvocationContext invocationContext) throws Exception {
        log.info(AROUND_INVOKE.toString() + " around " + invocationContext.getTarget().getClass() + " " + invocationContext.getMethod().getName());

        for (String key : invocationContext.getContextData().keySet()) {
            log.info(on(":").join(key, invocationContext.getContextData().get(key)));
        }

        return invocationContext.proceed();
    }
}
