package com.gmaslowski.singleton.util;

import com.gmaslowski.singleton.BeanManagedConcurrencySomething;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Asynchronous;
import javax.ejb.ConcurrentAccessTimeoutException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Random;

import static com.gmaslowski.singleton.util.ThreadHelper.sleepForMillis;

@Stateless
@Asynchronous
public class AsynchronousBeanSetter {
    private static final Logger log = LoggerFactory.getLogger(AsynchronousBeanSetter.class);

    @EJB
    BeanManagedConcurrencySomething concurrencySomething;

    public void setTimes(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            try {
                concurrencySomething.set();
            } catch (ConcurrentAccessTimeoutException cate) {
                log.warn("exc: {}", cate.getMessage());
            }
            sleepForMillis(new Random().nextInt(200));
        }
    }

    public void start() {
        while (true) {
            try {
                log.info("values are: {}", concurrencySomething.getValues());
            } catch (ConcurrentAccessTimeoutException cate) {
                log.warn("exc: {}", cate.getMessage());
            }
            sleepForMillis(new Random().nextInt(100));
        }
    }

    public void resetTimes(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            try {
                concurrencySomething.reset();
            } catch (ConcurrentAccessTimeoutException cate) {
                log.warn("exc: {}", cate.getMessage());
            }
            sleepForMillis(new Random().nextInt(200));
        }
    }
}
