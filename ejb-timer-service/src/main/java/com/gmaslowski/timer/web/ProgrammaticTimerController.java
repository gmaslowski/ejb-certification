package com.gmaslowski.timer.web;

import com.gmaslowski.timer.schedule.AnnotationProgrammaticTimer;
import com.gmaslowski.timer.schedule.ProgrammaticTimer;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import static com.gmaslowski.timer.ProgrammaticTimerName.EVERY_1_MINUTE;
import static com.gmaslowski.timer.ProgrammaticTimerName.EVERY_6_SECONDS;
import static com.gmaslowski.timer.ProgrammaticTimerName.EVERY_7_SECONDS;
import static com.gmaslowski.timer.ProgrammaticTimerName.IN_10_SECONDS;
import static com.gmaslowski.timer.ProgrammaticTimerName.IN_1_MINUTE;
import static com.gmaslowski.timer.schedule.ProgrammaticTimerInfo.ProgrammaticTimerInfoBuilder.programmaticTimerInfo;
import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.joda.time.DateTime.now;

@Path("/programmatic")
public class ProgrammaticTimerController {

    public static final long INITIAL_DELAY = 0L;

    @EJB
    private ProgrammaticTimer programmaticTimer;

    @EJB
    private AnnotationProgrammaticTimer annotationProgrammaticTimer;

    @POST
    @Path("/in10seconds")
    public String in10seconds() {
        programmaticTimer.createSingleActionTimer(
                now().plusSeconds(10).toDate(),
                programmaticTimerInfo().info(IN_10_SECONDS).name(IN_10_SECONDS).build());

        return "OK";
    }

    @POST
    @Path("/in1minute")
    public String in1minute() {
        programmaticTimer.createSingleActionTimer(
                INITIAL_DELAY,
                programmaticTimerInfo().info(IN_1_MINUTE).name(IN_1_MINUTE).build());
        return "OK";
    }

    @POST
    @Path("/every7seconds")
    public String every7seconds() {
        programmaticTimer.createConstantTimer(
                now().toDate(),
                SECONDS.toMillis(7),
                programmaticTimerInfo().info(EVERY_7_SECONDS).name(EVERY_7_SECONDS).build());
        return "OK";
    }

    @POST
    @Path("/every1minute")
    public String every1minute() {
        programmaticTimer.createConstantTimer(
                INITIAL_DELAY,
                MINUTES.toMillis(1),
                programmaticTimerInfo().info(EVERY_1_MINUTE).name(EVERY_1_MINUTE).build());
        return "OK";
    }

    @POST
    @Path("/annotation/every6seconds")
    public String every6seconds() {
        annotationProgrammaticTimer.createIntervalTimer(
                now().toDate(),
                SECONDS.toMillis(6),
                programmaticTimerInfo().info(EVERY_6_SECONDS).name(EVERY_6_SECONDS).build());
        return "OK";
    }

    @POST
    @Path("/annotation/every6seconds/cancel")
    public String cancelEvery6seconds() {
        annotationProgrammaticTimer.cancel(EVERY_6_SECONDS);
        return "OK";
    }

    @GET
    @Path("/timeouts")
    public String getTimeouts() {
        programmaticTimer.logTimeouts();
        return "OK";
    }
}
