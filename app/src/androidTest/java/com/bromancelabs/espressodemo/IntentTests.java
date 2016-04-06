package com.bromancelabs.espressodemo;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.bromancelabs.espressodemo.activities.InputDataActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class IntentTests {

    private static final String INPUT_TEXT = "Adrienne hates...";
    private static final String ACTIVITY_PACKAGE_NAME = "com.bromancelabs.espressodemo";
    private static final String EXTRA_TEXT = "extra_text";

    @Rule
    public IntentsTestRule<InputDataActivity> intentRule = new IntentsTestRule<>(InputDataActivity.class);

    @Test
    public void intentShouldHaveExtra() {
        onView(withId(R.id.txt_inputField)).perform(typeText(INPUT_TEXT), closeSoftKeyboard());
        onView(withId(R.id.btn_submit)).perform(click());
        intended(toPackage(ACTIVITY_PACKAGE_NAME));
        intended(hasExtra(EXTRA_TEXT, INPUT_TEXT));
    }
}
