package com.curso.android.app.practica.appmiguelmustafa

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import android.widget.TextView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import com.curso.android.app.practica.appmiguelmustafa.view.MainActivity




/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testCompareButton() {
        onView(withId(R.id.texto1)).perform(typeText("Es igual"))
        onView(withId(R.id.texto2)).perform(typeText("Es igual"))
        onView(withId(R.id.btnComparar)).perform(click())

        // Asegurarse de que el resultado se muestra correctamente en el TextView
        onView(withId(R.id.textoResultado)).check { view, _ ->
            val resultTextView = view as TextView
            assertEquals("Los textos son iguales", resultTextView.text.toString())
        }
    }





}