package com.gmaslowski.timer.web;

import com.gmaslowski.timer.schedule.ApplicationSchedule;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/application")
public class ApplicationScheduleController {

    @EJB
    private ApplicationSchedule appSchedule;

    @GET
    @Path("/timeouts")
    public String getTimeouts() {
        appSchedule.logTimeouts();
        return "OK";
    }


}
