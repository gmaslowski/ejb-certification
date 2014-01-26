package com.gmaslowski.interceptor.singleton.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static com.gmaslowski.interceptor.singleton.interceptor.SingletonPassingValueMethodInterceptor.PASSED_KEY;
import static javax.enterprise.inject.spi.InterceptionType.AROUND_INVOKE;

@Interceptor
public class SingletonRetrievingValueMethodInterceptor implements SingletonInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SingletonRetrievingValueMethodInterceptor.class);

    @AroundInvoke
    @Override
    public Object aroundInvokeInterceptor(InvocationContext invocationContext) throws Exception {
        log.info(AROUND_INVOKE.toString() + " class: " + invocationContext.getTarget().getClass() + " method: " + invocationContext.getMethod());

        String passedValue = (String) invocationContext.getContextData().get(PASSED_KEY);

        log.info("Got " + PASSED_KEY + ":" + passedValue + " from invocationContext.");

        return invocationContext.proceed();
    }

    @Override
    public void postConstructInterceptor(InvocationContext invocationContext) {

    }

    @Override
    public void preDestroyInterceptor(InvocationContext invocationContext) {

    }
}
