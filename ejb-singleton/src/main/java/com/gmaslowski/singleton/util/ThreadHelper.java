package com.gmaslowski.singleton.util;

public class ThreadHelper {

    public static void sleepForMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException swallow) {
        }
    }
}
