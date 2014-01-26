package com.gmaslowski.interceptor.order.interceptor;

import com.gmaslowski.interceptor.singleton.interceptor.SingletonInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class ThirdInterceptor implements SingletonInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ThirdInterceptor.class);

    @AroundInvoke
    @Override
    public Object aroundInvokeInterceptor(InvocationContext invocationContext) throws Exception {
        log.info("ThirdInterceptor");
        return invocationContext.proceed();
    }

    @Override
    public void postConstructInterceptor(InvocationContext invocationContext) {

    }

    @Override
    public void preDestroyInterceptor(InvocationContext invocationContext) {

    }
}
