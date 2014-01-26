package com.gmaslowski.interceptor.stateless.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.enterprise.inject.spi.InterceptionType.AROUND_INVOKE;

@Interceptor
public class StatelessServiceSecondMethodInterceptor implements ServiceInterceptor {

    private static final Logger log = LoggerFactory.getLogger(StatelessServiceSecondMethodInterceptor.class);

    @Override
    public void postConstructIntercept(InvocationContext invocationContext) throws Exception {

    }

    @Override
    public void preDestroyIntercept(InvocationContext invocationContext) throws Exception {

    }

    @AroundInvoke
    @Override
    public Object aroundInvokeIntercept(InvocationContext invocationContext) throws Exception {
        log.info(AROUND_INVOKE.toString() + " around " + invocationContext.getTarget().getClass() + " " + invocationContext.getMethod().getName());
        return invocationContext.proceed();
    }

}
