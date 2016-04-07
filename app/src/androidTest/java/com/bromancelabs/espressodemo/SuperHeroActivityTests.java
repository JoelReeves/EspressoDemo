package com.bromancelabs.espressodemo;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.bromancelabs.espressodemo.activities.SuperHeroActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.bromancelabs.espressodemo.utils.RecyclerViewUtils.atPosition;
import static com.bromancelabs.espressodemo.utils.RecyclerViewUtils.hasItemsCount;
import static com.bromancelabs.espressodemo.utils.RecyclerViewUtils.withName;

public class SuperHeroActivityTests {

    private static final String BATMAN = "Batman";
    private static final String DAREDEVIL = "DareDevil";
    private static final String FLASH = "Flash";
    private static final int DAREDEVIL_POSITION = 4;
    private static final int ITEM_COUNT = 5;

    @Rule
    public ActivityTestRule<SuperHeroActivity> activityRule = new ActivityTestRule<>(SuperHeroActivity.class);

    @Test
    public void recyclerViewShouldBeVisible() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void recyclerViewShouldHaveFiveItems() {
        onView(withId(R.id.recyclerView)).check(matches(hasItemsCount(ITEM_COUNT)));
    }

    @Test
    public void recyclerViewShouldHaveBatmanHero() {
        onView(withId(R.id.recyclerView)).check(matches(hasDescendant(withText(BATMAN))));
    }

    @Test
    public void recyclerViewShouldHaveDaredevilAsFifthItem() {
        onView(withId(R.id.recyclerView))
                .check(matches(atPosition(DAREDEVIL_POSITION, hasDescendant(withText(DAREDEVIL)))));

        /*

        Or if the item you're looking for isn't visible on the screen, scroll to it first

         onView(withId(R.id.recyclerView))
            .perform(scrollToPosition(100))
            .check(matches(atPosition(100, withText("Text You Are Looking For"))));

         */
    }

    @Test
    public void recyclerViewCanScrollToFlashHero() {
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollTo(withName(FLASH)));
    }
}
