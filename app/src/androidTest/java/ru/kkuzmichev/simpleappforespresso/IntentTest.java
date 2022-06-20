package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.AllOf.allOf;

import android.content.Intent;
import android.widget.ActionMenuView;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)
public class IntentTest {

    @Rule
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(MainActivity.class);
    @Test
    public void checkIntent() {
        ViewInteraction settings = onView(
                withParent(isAssignableFrom(ActionMenuView.class))).perform(click());
        ViewInteraction settingsItem = onView(allOf(withId(R.id.title), withText("Settings")));
        settings.check(
                matches(isDisplayed()));
        //Intents.init();//
        // ... Если вы решли реализовать проверку с "подписыванием" на Intent
       settings.perform(click()); //Для запуска intent
        //Проверяем intent, он должен передавать url и action
        //Intents..
        settingsItem.check(
                matches(isDisplayed()));
        settingsItem.perform((click()));
        intended (allOf(hasData("https://google.com"), hasAction(Intent.ACTION_VIEW)));
        //Intents.release();
   }
}
