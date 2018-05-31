/*
 * Created by YSN Studio on 6/1/18 5:30 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 6/1/18 5:20 AM
 */

package com.ysn.simpleviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_view_count_activity_main)
    TextView textViewCountActivityMain;

    private ClickCounterViewModel clickCounterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        clickCounterViewModel = ViewModelProviders.of(this).get(ClickCounterViewModel.class);
        displayClickCount();
    }

    @OnClick({
            R.id.button_increment_activity_main,
            R.id.button_decrement_activity_main
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_increment_activity_main:
                clickCounterViewModel.setCount(clickCounterViewModel.getCount() + 1);
                displayClickCount();
                break;
            case R.id.button_decrement_activity_main:
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
