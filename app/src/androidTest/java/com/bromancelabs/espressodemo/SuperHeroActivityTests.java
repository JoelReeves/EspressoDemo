package com.bromancelabs.espressodemo;

import android.support.test.rule.ActivityTestRule;

import com.bromancelabs.espressodemo.activities.SuperHeroActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SuperHeroActivityTests {

    @Rule
    public ActivityTestRule<SuperHeroActivity> activityRule = new ActivityTestRule<>(SuperHeroActivity.class);

    @Test
    public void recyclerViewShouldBeVisible() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }
}
