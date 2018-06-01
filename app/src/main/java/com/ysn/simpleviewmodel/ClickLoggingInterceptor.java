/*
 * Created by YSN Studio on 6/1/18 11:18 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 11:12 AM
 */

package com.ysn.simpleviewmodel;

import android.util.Log;

class ClickLoggingInterceptor {

    private static final String TAG = ClickLoggingInterceptor.class.getSimpleName();

    public void intercept(int clickCount) {
        Log.d(TAG, "processed click: " + clickCount);
    }

}
