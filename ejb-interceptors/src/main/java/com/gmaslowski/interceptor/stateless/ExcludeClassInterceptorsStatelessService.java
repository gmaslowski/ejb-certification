package com.gmaslowski.interceptor.stateless;

import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceClassInterceptor;
import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceFirstMethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(StatelessServiceClassInterceptor.class)
public class ExcludeClassInterceptorsStatelessService implements Loggable {

    private static final Logger log = LoggerFactory.getLogger(ExcludeClassInterceptorsStatelessService.class);

    @Interceptors(StatelessServiceFirstMethodInterceptor.class)
    @ExcludeClassInterceptors
    @Override
    public void logMe(String message) {
        // should be only default and method defined
        log.info(message);
    }
}
