package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)
public class TextTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingRecource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingRecource);
    }

    @Test
    public void textHomeCheck() {
        ViewInteraction mainText = onView(
                withId(R.id.text_home)
        );
        mainText.check(
                matches(
                        withText("This is home fragment")
                )
        );
    }

    @ Test
    public void checkGalleryListItem() {
        ViewInteraction appCompatImageButton = onView(withContentDescription("Open navigation drawer"));
        ViewInteraction menuItems = onView(withId(R.id.nav_gallery));
        ViewInteraction recycleList = onView(withId(R.id.recycle_view));
        ViewInteraction galleryItem = onView(allOf(withId(R.id.item_number), withText("7")));



        appCompatImageButton.check(matches((isDisplayed())));
        appCompatImageButton.perform(click());
        menuItems.check(matches(isDisplayed()));
        menuItems.perform(click());
        recycleList.check(matches(isDisplayed()));
        galleryItem.check(matches(isDisplayed()));
        recycleList.check(matches(CustomViewAssertion.isRecyclerView()));
        recycleList.check(matches(CustomViewMatcher.recyclerViewSizeMatcher(10)));




    }

}
