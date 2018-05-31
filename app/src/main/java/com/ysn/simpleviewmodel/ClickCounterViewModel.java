/*
 * Created by YSN Studio on 6/1/18 5:38 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 5:38 AM
 */

package com.ysn.simpleviewmodel;

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
