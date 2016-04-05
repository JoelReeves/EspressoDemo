package com.bromancelabs.espressodemo;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bromancelabs.espressodemo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldHaveEmptyEditTextField() {
        onView(withId(R.id.txt_inputField)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void shouldHaveSubmitButton() {
        onView(withId(R.id.btn_submit)).check(ViewAssertions.matches(isDisplayed()));
    }
}
