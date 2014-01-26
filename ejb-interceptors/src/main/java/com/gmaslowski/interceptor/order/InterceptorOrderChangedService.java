package com.gmaslowski.interceptor.order;

import com.gmaslowski.interceptor.order.interceptor.FirstInterceptor;
import com.gmaslowski.interceptor.order.interceptor.SecondInterceptor;
import com.gmaslowski.interceptor.order.interceptor.ThirdInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

@Singleton
@Interceptors({FirstInterceptor.class, SecondInterceptor.class, ThirdInterceptor.class})
public class InterceptorOrderChangedService implements OrderChangedLoggable {

    private static final Logger log = LoggerFactory.getLogger(InterceptorOrderChangedService.class);

    @Override
    public void logMe(String message) {
        log.info(message);
    }

    @Override
    public void logMeWithChangedOrder(String message) {
        log.info(message);
    }
}
