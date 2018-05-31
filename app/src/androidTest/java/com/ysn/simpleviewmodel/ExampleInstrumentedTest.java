/*
 * Created by YSN Studio on 6/1/18 5:30 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/24/18 1:20 PM
 */

package com.ysn.simpleviewmodel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.ysn.simpleviewmodel", appContext.getPackageName());
    }
}
