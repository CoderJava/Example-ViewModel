/*
 * Created by YSN Studio on 6/2/18 7:28 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/2/18 7:27 PM
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
    private LiveDataFormatTimerViewModel liveDataFormatTimerViewModel;

    @BindView(R.id.text_view_timer_value_activity_demo_live_data)
    TextView textViewTimerValue;
    @BindView(R.id.text_view_second_timer_value_activity_demo_live_data)
    TextView textViewSecondTimerValue;
    @BindView(R.id.text_view_minute_timer_value_activity_demo_live_data)
    TextView textViewMinuteTimerValue;
    @BindView(R.id.text_view_hour_timer_value_activity_demo_live_data)
    TextView textViewHourTimerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_live_data);
        ButterKnife.bind(this);
        // if external class Observer
        getLifecycle().addObserver(new MyObserver());

        // if internal of LifecycleOwner
        /*getLifecycle().addObserver(this);*/

        // to get current state lifecycle
        /*getLifecycle().getCurrentState();*/

        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
        liveDataFormatTimerViewModel = ViewModelProviders.of(this).get(LiveDataFormatTimerViewModel.class);
        subscribeElapsedTimeObserver();
    }

    private void subscribeElapsedTimeObserver() {
        liveDataTimerViewModel.getElapsedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long newValue) {
                String newText = getString(R.string.elapsed_time_format, newValue);
                displayTimerValue(newText);
                liveDataFormatTimerViewModel.setInitialTime(newValue);
                Log.d(TAG, "Updating timer");
            }
        });

        liveDataFormatTimerViewModel.getFormatElapsedTime().observe(this, new Observer<FormatTimerViewModel>() {
            @Override
            public void onChanged(@Nullable FormatTimerViewModel formatTimerViewModel) {
                int second = formatTimerViewModel.getSecond();
                int minute = formatTimerViewModel.getMinute();
                int hour = formatTimerViewModel.getHour();
                displayFormatTimerValue(second, minute, hour);
                Log.d(TAG, "Updating format timer");
            }
        });
    }

    private void displayTimerValue(String value) {
        textViewTimerValue.setText(String.valueOf(value));
    }

    private void displayFormatTimerValue(int second, int minute, int hour) {
        textViewSecondTimerValue.setText(getString(R.string.second_format, second));
        textViewMinuteTimerValue.setText(getString(R.string.minute_format, minute));
        textViewHourTimerValue.setText(getString(R.string.hour_format, hour));
    }

}
