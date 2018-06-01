/*
 * Created by YSN Studio on 6/2/18 2:20 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/2/18 2:17 AM
 */

package com.ysn.simpleviewmodel.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;

public class LiveDataFormatTimerViewModel extends ViewModel {

    private static final String TAG = LiveDataFormatTimerViewModel.class.getSimpleName();
    private long initialTime;
    private MutableLiveData<FormatTimerViewModel> formatElapsedTime = new MutableLiveData<>();

    public LiveDataFormatTimerViewModel() {
        initialTime = 0;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
        int second = (int) this.initialTime;
        int minute = 0;
        int hour = 0;
        if (second / 3600 > 0) {
            hour = second / 3600;
            second = second % 3600;
            if (second / 60 > 0) {
                minute = second / 60;
                second = second % 60;
            }
        } else if (second / 60 > 0) {
            minute = second / 60;
            second = second % 60;
        }

        final int finalSecond = second;
        final int finalMinute = minute;
        final int finalHour = hour;
        FormatTimerViewModel formatTimerViewModel = new FormatTimerViewModel(finalSecond, finalMinute, finalHour);
        formatElapsedTime.setValue(formatTimerViewModel);
    }

    public LiveData<FormatTimerViewModel> getFormatElapsedTime() {
        return formatElapsedTime;
    }

}
