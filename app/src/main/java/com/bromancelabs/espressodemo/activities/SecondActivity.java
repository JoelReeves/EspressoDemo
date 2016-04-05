package com.bromancelabs.espressodemo.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bromancelabs.espressodemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_TEXT = "extra_text";

    @Bind(R.id.txt_submitted) TextView submittedTextView;

    public static Intent newIntent(Context context, String text) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        if (getIntent() != null && getIntent().getExtras() != null && !getIntent().getExtras().isEmpty()) {
            Timber.d("Submit success");
            String submittedText = getIntent().getStringExtra(EXTRA_TEXT);
            submittedTextView.setText(submittedText);
        } else {
            Timber.d("Submit failure");
        }
    }
}
