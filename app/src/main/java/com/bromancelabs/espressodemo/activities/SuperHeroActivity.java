package com.bromancelabs.espressodemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hero, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuStartInputDataActivity:
                startActivity(new Intent(this, InputDataActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
