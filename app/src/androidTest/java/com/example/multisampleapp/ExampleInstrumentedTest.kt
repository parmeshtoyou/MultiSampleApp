package com.example.multisampleapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.multisampleapp.ui.home.HomeFragment
import org.junit.After

import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun executeBeforeTest() {
        Log.d(TAG, "executeBeforeTest")
    }

    @After
    fun executeAfterTest() {
        Log.d(TAG, "executeAfterTest")
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.multisampleapp", appContext.packageName)
    }


    @Test
    fun testFabIsDisplayed() {
        val fragmentArgs = Bundle()
        val scenario = launchFragmentInContainer<HomeFragment>(fragmentArgs)
        onView(withText("Click Me"))
            .perform(click())
        onView(withText("Hello New World...1")).check(ViewAssertions.matches(isDisplayed()))
    }

    companion object {
        private val TAG = "TAG-PARAM"
    }
}
