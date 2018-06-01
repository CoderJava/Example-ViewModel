/*
 * Created by YSN Studio on 6/2/18 2:20 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/2/18 1:40 AM
 */

package com.ysn.simpleviewmodel.livedata;

public class FormatTimerViewModel {

    private int second;
    private int minute;
    private int hour;

    public FormatTimerViewModel() {
    }

    public FormatTimerViewModel(int second, int minute, int hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
