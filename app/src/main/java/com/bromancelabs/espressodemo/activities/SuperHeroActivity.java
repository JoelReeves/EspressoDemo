package com.bromancelabs.espressodemo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.bromancelabs.espressodemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SuperHeroActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_hero);

        ButterKnife.bind(this);
    }
}
