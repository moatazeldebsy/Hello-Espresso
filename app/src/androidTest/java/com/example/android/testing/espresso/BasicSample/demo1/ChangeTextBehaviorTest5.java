package com.example.android.testing.espresso.BasicSample.demo1;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.example.android.testing.espresso.BasicSample.MainActivity;
import com.example.android.testing.espresso.BasicSample.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest5 {

    @Rule public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeText_sameActivity5() {
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(typeText("Hello test 5"));
        closeSoftKeyboard();
        onView(withId(R.id.changeTextBt))
            .perform(click());
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("Hello test 5")));
    }
}
