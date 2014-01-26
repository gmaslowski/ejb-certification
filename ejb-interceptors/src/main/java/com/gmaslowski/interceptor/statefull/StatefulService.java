package com.gmaslowski.interceptor.statefull;

import com.gmaslowski.interceptor.Loggable;
import com.gmaslowski.interceptor.statefull.interceptor.StatefulServiceClassInterceptor;
import com.gmaslowski.interceptor.stateless.StatelessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.interceptor.Interceptors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Stateful
@Interceptors(StatefulServiceClassInterceptor.class)
@StatefulTimeout(value = 2, unit = SECONDS)
public class StatefulService implements Loggable {

    private static final Logger log = LoggerFactory.getLogger(StatelessService.class);

    @Override
    public void logMe(String message) {
        // kinda tricky
        // postConstruct: StatelessServiceDefaultInterceptor !!
        // aroundInvoke: StatefulServiceClassInterceptor and StatelessServiceDefaultInterceptor

        // prePassivate: none because lifecycle mapping was taken from StatelessServiceDefaultInterceptor
        // postActivate: none because lifecycle mapping was taken from StatelessServiceDefaultInterceptor

        // preDestroy: StatelessServiceDefaultInterceptor !!
        log.info(message);
    }
}
