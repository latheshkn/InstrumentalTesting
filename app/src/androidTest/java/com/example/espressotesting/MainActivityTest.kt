package com.example.espressotesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    /*testing the activity visiblity*/
//    @Test
//    fun testIsActivityInView(){
//        val scenario=ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.main)).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun testVisiblityTitleButton() {
//        val scenario=ActivityScenario.launch(MainActivity::class.java)
//
//        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
//        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
//    }
//    @Test
//    fun testITitleTextDisplayed() {
//        val scenario=ActivityScenario.launch(MainActivity::class.java)
//
//        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
//
//    }

    /*Testing the activity navigation*/

    @Test
    fun navigationToSecondryActivity() {
        val activitySenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())

        onView(withId(R.id.secondery)).check(matches(isDisplayed()))
    }

    @Test
    fun navigateBackToMainActivity() {

        val activitySenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondery)).check(matches(isDisplayed()))
//        we can check the back press click both the ways as above and as mesioned here
        pressBack()

        onView(withId(R.id.main)).check(matches(isDisplayed()))


    }
}