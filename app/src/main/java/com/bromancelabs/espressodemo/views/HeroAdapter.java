package com.bromancelabs.espressodemo.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bromancelabs.espressodemo.R;
import com.bromancelabs.espressodemo.models.SuperHero;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HeroAdapter {

    public static class SuperHeroViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txt_hero_name) TextView heroName;

        public SuperHeroViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindSuperHero(SuperHero hero) {
            heroName.setText(hero.getName());
        }
    }
}
