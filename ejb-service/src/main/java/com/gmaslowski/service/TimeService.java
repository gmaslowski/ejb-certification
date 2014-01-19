package com.gmaslowski.service;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class TimeService {

    public Long currentTime() {
        return new Date().getTime();
    }

}
