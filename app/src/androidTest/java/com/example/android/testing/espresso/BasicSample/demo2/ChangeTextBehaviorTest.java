package com.example.android.testing.espresso.BasicSample.demo2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.example.android.testing.espresso.BasicSample.MainActivity;
import com.example.android.testing.espresso.BasicSample.R;

@SuppressWarnings("deprecation")
@RunWith(AndroidJUnit4.class)
public class ChangeTextBehaviorTest {
    @Rule public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    @SmallTest
    public void changeText_sameActivity1() {
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(typeText("Hello test 1"));
        closeSoftKeyboard();
        onView(withId(R.id.changeTextBt))
            .perform(click());
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("Hello test 1")));
    }
}
