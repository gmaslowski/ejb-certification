package com.gmaslowski.interceptor.singleton;


import com.gmaslowski.interceptor.Loggable;
import com.gmaslowski.interceptor.singleton.interceptor.SingletonClassInterceptor;
import com.gmaslowski.interceptor.singleton.interceptor.SingletonPassingValueMethodInterceptor;
import com.gmaslowski.interceptor.singleton.interceptor.SingletonRetrievingValueMethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.interceptor.Interceptors;

@Singleton
@ExcludeDefaultInterceptors
@Interceptors(SingletonClassInterceptor.class)
public class SingletonService implements Loggable {

    private static final Logger log = LoggerFactory.getLogger(SingletonService.class);

    @Override
    @Interceptors({SingletonPassingValueMethodInterceptor.class, SingletonRetrievingValueMethodInterceptor.class})
    public void logMe(String message) {
        log.info(message);
    }
}
