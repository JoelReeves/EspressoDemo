package com.bromancelabs.espressodemo;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bromancelabs.espressodemo.activities.SecondActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SecondActivityTests {

    @Rule
    public ActivityTestRule<SecondActivity> activityRule = new ActivityTestRule<>(SecondActivity.class);

    @Test
    public void shouldHaveHeaderTextField() {
        onView(withText(R.string.text_label)).check(ViewAssertions.matches(isDisplayed()));
    }
}
