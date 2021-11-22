package ru.mgkit.pr8_testing

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ru.mgkit.pr8_testing", appContext.packageName)
    }
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun result_isCorrect1() {
        Espresso.onView(withId(R.id.inputField)).perform(ViewActions.typeText("2"))
        Espresso.onView(withId(R.id.bin_Button)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.inputField))
            .check(ViewAssertions.matches(ViewMatchers.withText("10")))
    }
    @Test
    fun result_isCorrect2() {
        Espresso.onView(withId(R.id.inputField)).perform(ViewActions.typeText("15"))
        Espresso.onView(withId(R.id.hex_Button)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.inputField))
            .check(ViewAssertions.matches(ViewMatchers.withText("f")))
    }
    @Test
    fun result_isCorrect3() {
        Espresso.onView(withId(R.id.inputField)).perform(ViewActions.typeText("10"))
        Espresso.onView(withId(R.id.oct_Button)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.inputField))
            .check(ViewAssertions.matches(ViewMatchers.withText("12")))
    }
    @Test
    fun result_isCorrect4() {
        Espresso.onView(withId(R.id.inputField)).perform(ViewActions.typeText("1000"))
        Espresso.onView(withId(R.id.bin_Button)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.inputField))
            .check(ViewAssertions.matches(ViewMatchers.withText("1111101000")))
    }
    @Test
    fun result_isCorrect5() {
        Espresso.onView(withId(R.id.inputField)).perform(ViewActions.typeText(""))
        Espresso.onView(withId(R.id.hex_Button)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.inputField))
            .check(ViewAssertions.matches(ViewMatchers.withText("ОШИБКА!")))
    }

}