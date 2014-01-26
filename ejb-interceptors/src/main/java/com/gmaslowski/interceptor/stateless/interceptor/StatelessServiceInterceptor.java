package com.gmaslowski.interceptor.stateless.interceptor;

import javax.interceptor.InvocationContext;

public interface StatelessServiceInterceptor {

    void postConstructIntercept(InvocationContext invocationContext) throws Exception;

    void preDestroyIntercept(InvocationContext invocationContext) throws Exception;

    Object aroundInvokeIntercept(InvocationContext invocationContext) throws Exception;
}
