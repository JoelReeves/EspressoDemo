package com.bromancelabs.espressodemo.views;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bromancelabs.espressodemo.R;
import com.bromancelabs.espressodemo.models.SuperHero;
import com.bromancelabs.espressodemo.utils.NetworkUtils;
import com.bromancelabs.espressodemo.utils.UriUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.SuperHeroViewHolder> {

    private Context context;
    private List<SuperHero> heroList;

    public HeroAdapter(Context context, List<SuperHero> heroList) {
        if (heroList == null || heroList.isEmpty()) {
            throw new IllegalArgumentException("must provide a valid list");
        }
        this.context = context;
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

    public class SuperHeroViewHolder extends RecyclerView.ViewHolder {
        private static final String BATMAN_URL = "http://www.dccomics.com/characters/batman";
        private static final String SUPERMAN_URL = "https://en.wikipedia.org/wiki/Superman";
        private static final String GREEN_ARROW_URL = "https://en.wikipedia.org/wiki/Green_Arrow";
        private static final String FLASH_URL = "https://en.wikipedia.org/wiki/Flash_(comics)";
        private static final String DAREDEVIL_URL = "https://en.wikipedia.org/wiki/Daredevil_(Marvel_Comics)";

        @Bind(R.id.txt_hero_name) TextView heroName;

        public SuperHeroViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindSuperHero(SuperHero hero) {
            heroName.setText(hero.getName());
        }

        @OnClick(R.id.txt_hero_name)
        public void heroClicked() {

            switch (getLayoutPosition()) {
                case 0:
                    if (NetworkUtils.isNetworkAvailable(context)) {
                        UriUtils.goToURI(context, BATMAN_URL);
                    } else {
                        showNetworkError();
                    }
                    break;
                case 1:
                    if (NetworkUtils.isNetworkAvailable(context)) {
                        UriUtils.goToURI(context, SUPERMAN_URL);
                    } else {
                        showNetworkError();
                    }
                    break;
                case 2:
                    if (NetworkUtils.isNetworkAvailable(context)) {
                        UriUtils.goToURI(context, GREEN_ARROW_URL);
                    } else {
                        showNetworkError();
                    }
                    break;
                case 3:
                    if (NetworkUtils.isNetworkAvailable(context)) {
                        UriUtils.goToURI(context, FLASH_URL);
                    } else {
                        showNetworkError();
                    }
                    break;
                case 4:
                    if (NetworkUtils.isNetworkAvailable(context)) {
                        UriUtils.goToURI(context, DAREDEVIL_URL);
                    } else {
                        showNetworkError();
                    }
                    break;
            }
        }

        private void showNetworkError() {
            Snackbar.make(heroName, R.string.no_network_error, Snackbar.LENGTH_SHORT).show();
        }
    }
}
