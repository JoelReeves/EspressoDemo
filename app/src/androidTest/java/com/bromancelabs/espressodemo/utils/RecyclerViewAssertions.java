package com.bromancelabs.espressodemo.utils;

import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bromancelabs.espressodemo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.intent.Checks.checkNotNull;

public class RecyclerViewAssertions {

    public static Matcher<View> atPosition(final int position, @NonNull final Matcher<View> itemMatcher) {
        checkNotNull(itemMatcher);
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(final RecyclerView view) {
                RecyclerView.ViewHolder viewHolder = view.findViewHolderForAdapterPosition(position);
                if (viewHolder == null) {
                    // has no item on such position
                    return false;
                }
                return itemMatcher.matches(viewHolder.itemView);
            }
        };
    }

    public static Matcher<View> withName(final String expectedName) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                if (item != null && item.findViewById(R.id.txt_hero_name) != null) {
                    TextView name = (TextView) item.findViewById(R.id.txt_hero_name);
                    return !TextUtils.isEmpty(name.getText()) && name.getText().equals(expectedName);
                } else {
                    return false;
                }
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("found text: " + expectedName);
            }
        };
    }

    public static Matcher<View> hasItemsCount(final int finalCount) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                RecyclerView recyclerView = (RecyclerView) item;

                return recyclerView.getAdapter().getItemCount() == finalCount;

            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
