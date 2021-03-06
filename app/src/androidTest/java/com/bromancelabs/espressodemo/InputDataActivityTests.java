package com.bromancelabs.espressodemo;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bromancelabs.espressodemo.activities.InputDataActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class InputDataActivityTests {

    private static final String INPUT_TEXT = "Espresso";
    private static final String INVALID_TEXT = "invalid";

    @Rule
    public ActivityTestRule<InputDataActivity> activityRule = new ActivityTestRule<>(InputDataActivity.class);

    @Test
    public void shouldHaveEmptyEditTextField() {
        onView(withId(R.id.txt_inputField)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.txt_inputField)).check(matches(withText("")));
    }

    @Test
    public void shouldHaveSubmitButton() {
        onView(withId(R.id.btn_submit)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void editTextShouldContainText() {
        onView(withId(R.id.txt_inputField)).perform(typeText(INPUT_TEXT), closeSoftKeyboard());
        onView(withId(R.id.txt_inputField)).check(matches(withText(INPUT_TEXT)));
    }

    @Test
    public void editTextShouldContainInvalidText() {
        onView(withId(R.id.txt_inputField)).perform(typeText(INVALID_TEXT), closeSoftKeyboard());
        onView(withId(R.id.txt_inputField)).check(matches(not(withText(INPUT_TEXT))));
    }

    @Test
    public void inputTextWasSentToSecondActivity() {
        onView(withId(R.id.txt_inputField)).perform(typeText(INPUT_TEXT), closeSoftKeyboard());
        onView(withId(R.id.btn_submit)).perform(click());
        onView(withId(R.id.txt_submitted)).check(matches(withText(INPUT_TEXT)));
    }

    @Test
    public void returnFromSecondActivity() {
        onView(withId(R.id.txt_inputField)).perform(typeText(INPUT_TEXT), closeSoftKeyboard());
        onView(withId(R.id.btn_submit)).perform(click());
        onView(withId(R.id.txt_submitted)).check(matches(withText(INPUT_TEXT)));

        pressBack();

        onView(withId(R.id.txt_inputField)).check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.txt_inputField)).check(matches(withText("")));
        onView(withId(R.id.btn_submit)).check(ViewAssertions.matches(isDisplayed()));
    }
}
