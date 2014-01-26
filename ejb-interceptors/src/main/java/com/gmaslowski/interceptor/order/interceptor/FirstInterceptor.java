package com.gmaslowski.interceptor.order.interceptor;

import com.gmaslowski.interceptor.singleton.interceptor.SingletonInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class FirstInterceptor implements SingletonInterceptor {

    private static final Logger log = LoggerFactory.getLogger(FirstInterceptor.class);

    @AroundInvoke
    @Override
    public Object aroundInvokeInterceptor(InvocationContext invocationContext) throws Exception {
        log.info("FirstInterceptor");
        return invocationContext.proceed();
    }

    @Override
    public void postConstructInterceptor(InvocationContext invocationContext) {

    }

    @Override
    public void preDestroyInterceptor(InvocationContext invocationContext) {

    }
}
