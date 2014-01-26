package com.gmaslowski.interceptor.order;

import com.gmaslowski.interceptor.Loggable;

public interface OrderChangedLoggable extends Loggable {

    void logMeWithChangedOrder(String message);
}
