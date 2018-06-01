/*
 * Created by YSN Studio on 6/1/18 11:18 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 11:11 AM
 */

package com.ysn.simpleviewmodel;

public class LoggingClickCounterViewModel extends ClickCounterViewModel {

    private final ClickLoggingInterceptor loggingInterceptor;

    public LoggingClickCounterViewModel(ClickLoggingInterceptor loggingInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
    }

    @Override
    public void setCount(int count) {
        super.setCount(count);
        loggingInterceptor.intercept(count);
    }
}
