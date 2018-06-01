/*
 * Created by YSN Studio on 6/1/18 11:48 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 11:24 AM
 */

package com.ysn.simpleviewmodel.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ysn.simpleviewmodel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemoViewModelActivity extends AppCompatActivity {

    @BindView(R.id.text_view_count_activity_demo_view_model)
    TextView textViewCountActivityMain;

    private ClickCounterViewModel clickCounterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_view_model);
        ButterKnife.bind(this);

        // The factory and its dependencies instead should be injected with DI framework like Dagger
        LoggingClickCounterViewModelFactory factory = new LoggingClickCounterViewModelFactory(new ClickLoggingInterceptor());
        clickCounterViewModel = ViewModelProviders.of(this, factory)
                .get(LoggingClickCounterViewModel.class);
        displayClickCount();
    }

    @OnClick({
            R.id.button_increment_activity_demo_view_model,
            R.id.button_decrement_activity_demo_view_model
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_increment_activity_demo_view_model:
                clickCounterViewModel.setCount(clickCounterViewModel.getCount() + 1);
                displayClickCount();
                break;
            case R.id.button_decrement_activity_demo_view_model:
                clickCounterViewModel.setCount(clickCounterViewModel.getCount() - 1);
                displayClickCount();
                break;
            default:
                break;
        }
    }

    private void displayClickCount() {
        textViewCountActivityMain.setText(clickCounterViewModel.getCount());
    }

}
