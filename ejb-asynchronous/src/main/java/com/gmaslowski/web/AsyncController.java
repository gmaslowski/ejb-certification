package com.gmaslowski.web;

import com.gmaslowski.async.AsyncBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.gmaslowski.web.Sleeper.sleepForSeconds;

@Stateless
@Path("/asynchronous")
public class AsyncController {

    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    private Future<String> exceptionThrower;
    private Future<String> cancellable;

    @EJB
    private AsyncBean asyncBean;

    @GET
    @Path("/void")
    public String voider() {
        asyncBean.notReturningValue();
        return "OK";
    }

    @GET
    @Path("/exception")
    public String exceptionThrower() {
        exceptionThrower = asyncBean.throwsException();
        log.info("exception should be thrown by now, sleep to be sure");
        sleepForSeconds(2);
        try {
            exceptionThrower.get();
        } catch (InterruptedException swallowed) {

        } catch (ExecutionException ee) {
            log.info("I will always be wrapped by ee ", ee);
        }
        return "OK";
    }

    @GET
    @Path("/cancellable")
    public String cancellable() {
        cancellable = asyncBean.cancellable();
        log.info("execution started");
        sleepForSeconds(2);

        if (cancellable.isCancelled()) {
            log.info("not yet");
        }

        sleepForSeconds(2);
        cancellable.cancel(true);
        sleepForSeconds(5);

        if (cancellable.isCancelled()) {
            log.info("yes I'am cancelled");
        }

        try {
            cancellable.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            log.info("will I be here?");
        }

        if (cancellable.isDone()) {
            log.info("yes I'am done");
        }

        return "OK";
    }
}
