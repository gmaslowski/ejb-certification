package com.gmaslowski.interceptor.statefull.interceptor;

import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceInterceptor;

import javax.interceptor.InvocationContext;

public interface StatefulServiceInterceptor extends StatelessServiceInterceptor {

    void postActivateIntercept(InvocationContext invocationContext) throws Exception;

    void prePassivateIntercept(InvocationContext invocationContext) throws Exception;


}
