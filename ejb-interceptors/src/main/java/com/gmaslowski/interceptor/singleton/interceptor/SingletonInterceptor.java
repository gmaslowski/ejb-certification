package com.gmaslowski.interceptor.singleton.interceptor;

import javax.interceptor.InvocationContext;

public interface SingletonInterceptor {

    Object aroundInvokeInterceptor(InvocationContext invocationContext) throws Exception;

    void postConstructInterceptor(InvocationContext invocationContext) throws Exception;

    void preDestroyInterceptor(InvocationContext invocationContext);
}
