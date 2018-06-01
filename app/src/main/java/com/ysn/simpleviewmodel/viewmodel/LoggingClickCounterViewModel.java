/*
 * Created by YSN Studio on 6/1/18 11:49 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 11:19 AM
 */

package com.ysn.simpleviewmodel.viewmodel;

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
