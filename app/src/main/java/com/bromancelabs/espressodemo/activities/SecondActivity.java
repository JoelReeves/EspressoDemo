package com.bromancelabs.espressodemo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bromancelabs.espressodemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @Bind(R.id.txt_submitted) TextView submittedTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);
    }
}
