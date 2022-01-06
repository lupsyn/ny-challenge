package com.ebdz.search.utils

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule

abstract class BaseAndroidComposeTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
}
