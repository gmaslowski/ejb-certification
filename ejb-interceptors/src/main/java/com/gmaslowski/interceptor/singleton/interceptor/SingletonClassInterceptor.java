package com.gmaslowski.interceptor.singleton.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.enterprise.inject.spi.InterceptionType.AROUND_INVOKE;
import static javax.enterprise.inject.spi.InterceptionType.POST_CONSTRUCT;

@Interceptor
public class SingletonClassInterceptor implements SingletonInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SingletonClassInterceptor.class);

    @AroundInvoke
    @Override
    public Object aroundInvokeInterceptor(InvocationContext invocationContext) throws Exception {
        log.info(AROUND_INVOKE.toString() + " class: " + invocationContext.getTarget().getClass() + " method: " + invocationContext.getMethod());
        return invocationContext.proceed();
    }

    @PostConstruct
    @Override
    public void postConstructInterceptor(InvocationContext invocationContext) {
        log.info(POST_CONSTRUCT.toString() + ", notice when I'm being invoked.");
    }

    @Override
    public void preDestroyInterceptor(InvocationContext invocationContext) {

    }
}
