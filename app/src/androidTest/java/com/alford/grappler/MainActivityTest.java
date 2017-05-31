package com.alford.grappler;

import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


/**
 * Created by WilliamAlford on 4/14/17.
 */

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

//    @Test
//    public void testMoveToStoreActivity(){ //testing if user can move to StoreActivity from MainActivity
//      onView(withId(R.id.start_button)).perform(click());
//        onView(withId(R.id.recycler1)).check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void testUserCanClickonSearch(){//test if user can search in StoreActivity
//             onView(withId(R.id.start_button)).perform(click());
//        onView(withId(R.id.menu_search)).perform(click());
//
//
//
//    }
//
//    @Test
//    public void testIfLookGoesToDetail(){//test id look goes to DetailViewActivity
//        onView(withId(R.id.start_button)).perform(click());
//
//        //examine button makes test fail because used multiple times in hierarchy
//        onView(withId(R.id.examine_button)).perform(click());
//        onView(withId(R.id.luchaicon)).check(matches(isDisplayed()));
//    }

    @Test
    public void testIfRecyclerIsVisibleInStore(){
        onView(withId(R.id.start_button)).perform(click());
        onView(withId(R.id.recycler1)).check(matches(isDisplayed()));

    }




}

