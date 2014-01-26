package com.gmaslowski.interceptor.singleton.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class SingletonClassInterceptorSuperclassInterceptor implements SingletonInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SingletonClassInterceptorSuperclassInterceptor.class);


    @Override
    public Object aroundInvokeInterceptor(InvocationContext invocationContext) throws Exception {
        log.info("Superclass not defined bind, but should be invoked.");
        return invocationContext.proceed();
    }

    @AroundInvoke
    public Object aroundInvokeInterceptorSuperclass(InvocationContext invocationContext) throws Exception {
        log.info("Superclass not defined bind, but should be invoked.");
        return invocationContext.proceed();
    }


    @Override
    public void postConstructInterceptor(InvocationContext invocationContext) throws Exception {

    }

    @Override
    public void preDestroyInterceptor(InvocationContext invocationContext) {

    }
}
