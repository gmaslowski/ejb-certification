package com.gmaslowski.timer.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerHandle;
import javax.ejb.TimerService;
import java.util.Date;

@Stateless
public class AnnotationProgrammaticTimer {

    // TODO: transaction demarcation?
    // if rollback then creation and cancellation of timer is rolled back

    // TODO: what about security?
    // no security, ctx.getPrincipal() will return ANONYMOUS

    // TODO: thrown Exceptions?
    // IllegalStateException - if date is in minus, interval has a negative value
    // IllegalArgumentException
    // EJBException

    // TODO: do beans get invalidated on timer creation errors?
    // don't know yet, possibly yes if programmatic timer creation and EJBException is thrown

    private static final Logger log = LoggerFactory.getLogger(AnnotationProgrammaticTimer.class);

    @Resource
    private TimerService timerService;

    @Timeout
    public void timeout(Timer timer) {
        // will not be invoked.. only one @Timeout annotated method is allowed, same as implements TimerObjectl
        log.info("Ping from: " + ((ProgrammaticTimerInfo) timer.getInfo()).toString());
    }

    @Timeout
    public void timeout2(Timer timer) {
        // this one seems to be the more important :D
        // it's container specific
        log.info("Ping second timeout from: " + ((ProgrammaticTimerInfo) timer.getInfo()).toString());
    }

    public void cancel(String name) {
        for (Timer timer : timerService.getTimers()) {
            if (((ProgrammaticTimerInfo) timer.getInfo()).getName().equals(name)) {
                log.info("cancelling timer");
                timer.cancel();
            }
        }
    }

    public TimerHandle getHandle() {
        for (Timer timer : timerService.getTimers()) {
            // can get a handle to the timer and pass it on
            timer.getHandle();
        }
        return null;
    }

    public void createIntervalTimer(Date date, long interval, ProgrammaticTimerInfo info) {

        timerService.createTimer(date, interval, info);
    }

}
