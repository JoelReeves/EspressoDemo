package com.bromancelabs.espressodemo.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bromancelabs.espressodemo.R;
import com.bromancelabs.espressodemo.models.SuperHero;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.SuperHeroViewHolder> {

    private List<SuperHero> heroList;

    public HeroAdapter(List<SuperHero> heroList) {
        if (heroList == null || heroList.isEmpty()) {
            throw new IllegalArgumentException("must provide a valid list");
        }
        this.heroList = heroList;
    }

    @Override
    public SuperHeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row_item, parent, false);
        return new SuperHeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SuperHeroViewHolder holder, int position) {
        holder.bindSuperHero(heroList.get(position));
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

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
