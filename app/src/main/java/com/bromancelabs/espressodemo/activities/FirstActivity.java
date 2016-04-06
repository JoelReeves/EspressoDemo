package com.bromancelabs.espressodemo.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;

import com.bromancelabs.espressodemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class FirstActivity extends AppCompatActivity {

    @Bind(R.id.txt_inputField) EditText inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_submit)
    public void submitButtonClicked() {
        String text = inputEditText.getText().toString();

        if (!TextUtils.isEmpty(text)) {
            Timber.d("Submitted text: %s", text);
            inputEditText.setText("");
            startActivity(SecondActivity.newIntent(this, text));
        } else {
            Snackbar.make(inputEditText, R.string.snackbar_invalid_text, Snackbar.LENGTH_SHORT).show();
        }
    }
}
