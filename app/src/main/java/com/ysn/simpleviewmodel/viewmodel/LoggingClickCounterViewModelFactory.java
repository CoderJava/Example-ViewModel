/*
 * Created by YSN Studio on 6/1/18 11:49 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 11:19 AM
 */

package com.ysn.simpleviewmodel.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

public class LoggingClickCounterViewModelFactory implements ViewModelProvider.Factory {

    private final ClickLoggingInterceptor loggingInterceptor;

    public LoggingClickCounterViewModelFactory(ClickLoggingInterceptor loggingInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoggingClickCounterViewModel.class)) {
            return (T) new LoggingClickCounterViewModel(loggingInterceptor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
