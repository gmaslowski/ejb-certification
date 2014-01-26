package com.gmaslowski.interceptor.singleton.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.enterprise.inject.spi.InterceptionType.AROUND_INVOKE;

@Interceptor
public class SingletonPassingValueMethodInterceptor implements SingletonInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SingletonPassingValueMethodInterceptor.class);

    public static final String PASSED_KEY = "passed_key";
    public static final String PASSED_VALUE = "some_value";


    @AroundInvoke
    @Override
    public Object aroundInvokeInterceptor(InvocationContext invocationContext) throws Exception {
        log.info(AROUND_INVOKE.toString() + " class: " + invocationContext.getTarget().getClass() + " method: " + invocationContext.getMethod());

        log.info("Setting " + PASSED_KEY + ":" + PASSED_VALUE + " to invocationContext.");
        invocationContext.getContextData().put(PASSED_KEY, PASSED_VALUE);

        return invocationContext.proceed();
    }

    @Override
    public void postConstructInterceptor(InvocationContext invocationContext) {

    }

    @Override
    public void preDestroyInterceptor(InvocationContext invocationContext) {

    }
}
