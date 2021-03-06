package com.bromancelabs.espressodemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.bromancelabs.espressodemo.R;
import com.bromancelabs.espressodemo.models.SuperHero;
import com.bromancelabs.espressodemo.views.HeroAdapter;
import com.bromancelabs.espressodemo.views.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class SuperHeroActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_hero);

        ButterKnife.bind(this);

        setupRecyclerView();
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

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] heroStringArray = getResources().getStringArray(R.array.heroes);
        List<SuperHero> heroList = new ArrayList<>();

        for (String h: heroStringArray) {
            heroList.add(new SuperHero(h));
        }

        Timber.d(heroList.toString());

        HeroAdapter heroAdapter = new HeroAdapter(this, heroList);

        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.recyclerview_horizontal_divider));
        recyclerView.setAdapter(heroAdapter);
    }
}
