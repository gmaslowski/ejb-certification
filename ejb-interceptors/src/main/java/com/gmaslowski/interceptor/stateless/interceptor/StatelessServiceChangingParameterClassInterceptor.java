package com.gmaslowski.interceptor.stateless.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static javax.enterprise.inject.spi.InterceptionType.POST_CONSTRUCT;

@Interceptor
public class StatelessServiceChangingParameterClassInterceptor implements ServiceInterceptor {

    private static final Logger log = LoggerFactory.getLogger(StatelessServiceChangingParameterClassInterceptor.class);

    @PostConstruct
    @Override
    public void postConstructIntercept(InvocationContext invocationContext) {
        log.info(POST_CONSTRUCT.toString() + " on " + invocationContext.getTarget().getClass());
    }

    @Override
    public void preDestroyIntercept(InvocationContext invocationContext) {

    }

    @AroundInvoke
    @Override
    public Object aroundInvokeIntercept(InvocationContext invocationContext) throws Exception {
        Object[] params = invocationContext.getParameters();
        for (Object param : params) {
            log.info("Param: " + param);
        }

        log.info("Changing param value.");

        Object[] newParams = new Object[1];
        newParams[0] = "Changed parameter value!";
        invocationContext.setParameters(newParams);

        return invocationContext.proceed();
    }
}
