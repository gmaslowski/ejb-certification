package com.gmaslowski.web;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Sleeper {

    public static void sleepForMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException swallowed) {
        }
    }

    public static void sleepForSeconds(long seconds) {
        sleepForMillis(SECONDS.toMillis(seconds));
    }

}
