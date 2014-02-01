package com.gmaslowski.timer.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;
import javax.ejb.Timer;

import static com.gmaslowski.timer.ScheduledServiceName.EVERY_TEN_SECONDS;
import static com.gmaslowski.timer.ScheduledServiceName.EVERY_TWENTY_SECONDS;
import static com.gmaslowski.timer.ScheduledServiceName.TRY_EVERY_TEN_SECONDS;
import static com.google.common.base.Objects.toStringHelper;

@Stateless
public class ApplicationSchedule {

    private static final Logger log = LoggerFactory.getLogger(ApplicationSchedule.class);

    @Resource
    private EJBContext ejbContext;

    @Schedule(second = "*/10", minute = "*", hour = "*", persistent = true, info = EVERY_TEN_SECONDS)
    public void invokeMeEveryTenSeconds(Timer timer) {
        log.info("Ping from: " + timer.getInfo());
    }

    @Schedules({
            @Schedule(second = "*/10", minute = "*", hour = "*", persistent = true, info = EVERY_TEN_SECONDS),
            @Schedule(second = "*/20", minute = "*", hour = "*", persistent = true, info = EVERY_TWENTY_SECONDS)
    })
    // the schedules will be deleted and recreated with each redeploy
    // cannot be cancelled
    // cannot be obtained
    public void invokeMeEveryTenSecondsAndEveryTwentySeconds(Timer timer) {
        log.info("Ping from: " + timer.getInfo());
    }

    @Schedule(second = "*/10", persistent = true, info = TRY_EVERY_TEN_SECONDS)
    public void tryInvokeMeEveryTenSeconds(Timer timer) {
        // it will not be invoked every 10 seconds,
        // because default values for minute and hour is 0 !
        log.info("Ping from: " + timer.getInfo());
    }


    public void logTimeouts() {
        // nothing will be shown,
        // Application Schedules cannot be controlled after creation
        for (Timer timer : ejbContext.getTimerService().getTimers()) {
            log.info(toStringHelper(Timer.class)
                    .add("timerInfo", timer.getInfo())
                    .add("isPersistent", timer.isPersistent())
                    .add("nextTimeout", timer.getNextTimeout())
                    .toString());
        }
    }

}
