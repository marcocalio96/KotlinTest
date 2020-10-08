package com.example.kotlinapp


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.example.kotlinapp.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`
import kotlin.random.Random

@LargeTest
@RunWith(AndroidJUnit4::class)
class Differenza {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    fun testing(a : Int, b : Int){
        val tabView = onView(
            allOf(
                withContentDescription("OBJECT 2"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabLayout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        tabView.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.editTextNumberDecimal),
                childAtPosition(
                    withParent(withId(R.id.viewPager)),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText(a.toString()), closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(R.id.sotbtn), withText("-"),
                childAtPosition(
                    withParent(withId(R.id.viewPager)),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editTextNumberDecimal),
                childAtPosition(
                    withParent(withId(R.id.viewPager)),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText(b.toString()), closeSoftKeyboard())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.sotbtn), withText("="),
                childAtPosition(
                    withParent(withId(R.id.viewPager)),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.risultato), withText((a-b).toString()),
                childAtPosition(
                    withParent(withId(R.id.viewPager)),
                    3
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText((a-b).toString())))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }


    @Test
    fun differenza() {
        var c = 0;
        for(c in 1..20){
            testing(Random.nextInt(1,100),Random.nextInt(1,100))
        }
    }
}

