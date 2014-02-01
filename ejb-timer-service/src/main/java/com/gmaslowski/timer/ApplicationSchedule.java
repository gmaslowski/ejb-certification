package com.gmaslowski.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;

import static com.gmaslowski.timer.ScheduledServiceName.EVERY_TEN_SECONDS;
import static com.gmaslowski.timer.ScheduledServiceName.TRY_EVERY_TEN_SECONDS;

@Stateless
public class ApplicationSchedule {

    private static final Logger log = LoggerFactory.getLogger(ApplicationSchedule.class);

    @Schedule(second = "*/10", minute = "*", hour = "*", persistent = true, info = EVERY_TEN_SECONDS)
    public void invokeMeEveryTenSeconds(Timer timer) {
        log.info("I am invoked every 10 seconds");
    }

    @Schedule(second = "*/10", persistent = true, info = TRY_EVERY_TEN_SECONDS)
    public void tryInvokeMeEveryTenSeconds(Timer timer) {
        // it will not be invoked every 10 seconds,
        // because default values for minute and hour is 0 !
        log.info("I am not invoked every 10 seconds");
    }

}
