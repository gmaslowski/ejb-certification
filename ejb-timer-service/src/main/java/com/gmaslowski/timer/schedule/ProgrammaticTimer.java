package com.gmaslowski.timer.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TimedObject;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import java.util.Date;

import static com.google.common.base.Objects.toStringHelper;

@Stateless
public class ProgrammaticTimer implements TimedObject {

    // createTimer() methods are taking Serializable info
    // create*Timer() methods are taking TimerConfig (which can have info seted)

    private static final Logger log = LoggerFactory.getLogger(ProgrammaticTimer.class);

    @Resource
    private EJBContext ejbContext;

    @Override
    public void ejbTimeout(Timer timer) {
        log.info("Ping from: " + infoFrom(timer));
    }

    // will be executed once
    public void createSingleActionTimer(Date date, ProgrammaticTimerInfo timerInfo) {
        TimerConfig config = new TimerConfig();
        config.setInfo(timerInfo);

        // will be executed even if while timeout the server was down
        config.setPersistent(true);
        ejbContext.getTimerService().createSingleActionTimer(date, config);
    }

    // will be executed once
    public void createSingleActionTimer(Long millis, ProgrammaticTimerInfo timerInfo) {
        TimerConfig config = new TimerConfig();
        config.setInfo(timerInfo);

        ejbContext.getTimerService().createSingleActionTimer(millis, config);
    }

    // will be executed every specified time
    public void createConstantTimer(Long millisStart, long interval, ProgrammaticTimerInfo timerInfo) {
        ejbContext.getTimerService().createTimer(millisStart, interval, timerInfo);
    }

    // will be executed every specified time
    public void createConstantTimer(Date dateStart, long interval, ProgrammaticTimerInfo timerInfo) {
        ejbContext.getTimerService().createTimer(dateStart, interval, timerInfo);
    }

    public void logTimeouts() {
        for (Timer timer : ejbContext.getTimerService().getTimers()) {
            log.info(toStringHelper(Timer.class)
                    .add("programmaticTimerInfo", infoFrom(timer))
                    .add("isPersistent", timer.isPersistent())
                    .add("nextTimeout", timer.getNextTimeout())
                    .toString());
        }
    }


    private String infoFrom(Timer timer) {
        return ((ProgrammaticTimerInfo) timer.getInfo()).toString();
    }

}
