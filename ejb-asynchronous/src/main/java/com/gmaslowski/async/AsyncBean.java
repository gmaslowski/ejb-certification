package com.gmaslowski.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

import static com.gmaslowski.web.Sleeper.sleepForSeconds;

@Stateless
@LocalBean
public class AsyncBean {

    private static final Logger log = LoggerFactory.getLogger(AsyncBean.class);
    private static final boolean trickCompilerToAlwaysThrowException = true;


    @Resource
    private SessionContext sessionContext;

    @Asynchronous
    public void notReturningValue() {
        log.info("i am not returning value");
    }

    @Asynchronous
    public Future<String> cancellable() {
        // can throw any exceptions
        while (true) {
            sleepForSeconds(2);
            log.info("cancellable working");
            if (sessionContext.wasCancelCalled()) {
                log.info("someone just cancelled me");
                break;
            }
        }
        return new AsyncResult<String>("OK"); // AsyncResult is the only possible type to use
    }

    @Asynchronous
    public Future<String> throwsException() {
        if (trickCompilerToAlwaysThrowException) {
            log.info("will throw an exception");
            throw new AsyncBeanException();
        }
        return new AsyncResult<String>("OK");
    }


}
