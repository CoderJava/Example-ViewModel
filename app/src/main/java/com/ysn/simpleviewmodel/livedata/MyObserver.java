/*
 * Created by YSN Studio on 6/2/18 7:28 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/2/18 7:18 PM
 */

package com.ysn.simpleviewmodel.livedata;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MyObserver implements LifecycleObserver {

    private static final String TAG = MyObserver.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.d(TAG, "resumed observing lifecycle.");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.d(TAG, "paused observing lifecycle.");
    }

}
