package com.gmaslowski.interceptor.stateless;

import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceChangingParameterClassInterceptor;
import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceClassInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.interceptor.Interceptors;

@Stateless
@ExcludeDefaultInterceptors
@Interceptors({StatelessServiceClassInterceptor.class, StatelessServiceChangingParameterClassInterceptor.class})
// remember that only one (the first declared) interceptor is going to serve as lifecycle callback interceptor !!
public class ExcludeDefaultInterceptorsStatelessService implements Loggable {

    private static final Logger log = LoggerFactory.getLogger(ExcludeDefaultInterceptorsStatelessService.class);


    @Override
    public void logMe(String message) {
        // order: class, method interceptors
        log.info(message);
    }
}
