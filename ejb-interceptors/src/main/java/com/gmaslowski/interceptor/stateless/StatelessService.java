package com.gmaslowski.interceptor.stateless;

import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceChangingParameterClassInterceptor;
import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceClassInterceptor;
import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceFirstMethodInterceptor;
import com.gmaslowski.interceptor.stateless.interceptor.StatelessServiceSecondMethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import static javax.enterprise.inject.spi.InterceptionType.POST_CONSTRUCT;
import static javax.enterprise.inject.spi.InterceptionType.PRE_DESTROY;

@Stateless
@Interceptors({StatelessServiceClassInterceptor.class, StatelessServiceChangingParameterClassInterceptor.class})
public class StatelessService implements Loggable {

    private static final Logger log = LoggerFactory.getLogger(StatelessService.class);

    @PostConstruct
    public void postConstruct() {
        log.info(POST_CONSTRUCT.toString());
    }

    @PreDestroy
    public void preDestroy() {
        log.info(PRE_DESTROY.toString());
    }

    @Interceptors({StatelessServiceFirstMethodInterceptor.class, StatelessServiceSecondMethodInterceptor.class})
    public void logMe(String value) {
        log.info(value);
    }
}
