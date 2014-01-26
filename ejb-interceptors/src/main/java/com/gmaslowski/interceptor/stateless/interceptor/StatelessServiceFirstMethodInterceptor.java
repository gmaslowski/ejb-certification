package com.gmaslowski.interceptor.stateless.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.enterprise.inject.spi.InterceptionType.AROUND_INVOKE;

@Interceptor
public class StatelessServiceFirstMethodInterceptor implements ServiceInterceptor {

    private static final Logger log = LoggerFactory.getLogger(StatelessServiceFirstMethodInterceptor.class);

    @Override
    public void postConstructIntercept(InvocationContext invocationContext) {

    }

    @Override
    public void preDestroyIntercept(InvocationContext invocationContext) {

    }

    @AroundInvoke
    @Override
    public Object aroundInvokeIntercept(InvocationContext invocationContext) throws Exception {
        log.info(AROUND_INVOKE.toString() + " around " + invocationContext.getTarget().getClass() + " " + invocationContext.getMethod().getName());
        return invocationContext.proceed();
    }
}
