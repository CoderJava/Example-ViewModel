/*
 * Created by YSN Studio on 6/1/18 11:50 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 11:41 AM
 */

package com.ysn.simpleviewmodel.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ysn.simpleviewmodel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DemoLiveDataActivity extends AppCompatActivity {

    private static final String TAG = DemoLiveDataActivity.class.getSimpleName();
    private LiveDataTimerViewModel liveDataTimerViewModel;

    private final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
        @Override
        public void onChanged(@Nullable Long newValue) {
            String newText = getResources().getString(R.string.seconds, newValue);
            displayTimerValue(newText);
            Log.d(TAG, "Updating timer");
        }
    };

    @BindView(R.id.text_view_timer_value_activity_demo_live_data)
    TextView textViewTimerValueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_live_data);
        ButterKnife.bind(this);

        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
        subscribeElapsedTimeObserver();
    }

    private void subscribeElapsedTimeObserver() {
        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }

    private void displayTimerValue(String value) {
        textViewTimerValueText.setText(String.valueOf(value));
    }

}
