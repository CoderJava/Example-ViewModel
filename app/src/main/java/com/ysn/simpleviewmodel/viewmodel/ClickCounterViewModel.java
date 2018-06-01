/*
 * Created by YSN Studio on 6/1/18 11:49 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 11:19 AM
 */

package com.ysn.simpleviewmodel.viewmodel;

import android.arch.lifecycle.ViewModel;

public class ClickCounterViewModel extends ViewModel {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
