package com.ebdz.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.ebdz.compose.model.Screen
import com.ebdz.compose.navigation.NavGraph
import com.ebdz.designsystem.Theme
import com.ebdz.navigation.BOTTOM_TEST_TAG
import com.ebdz.navigation.SCREEN_TEST_TAG
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setup() {
        composeTestRule.setContent {
            Theme {
                NavGraph()
            }
        }
    }

    @Test
    fun test_homeScreenContentIsDisplayed() {
        val contentString = context.getString(R.string.home_content_description)

        composeTestRule.onNodeWithText(contentString, useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun test_bottomNavigation() {
        listOf(Screen.HomeScreen, Screen.SettingsScreen).forEach { section ->
            val title = context.getString(section.title)

            composeTestRule.onNodeWithTag(testTag = title + BOTTOM_TEST_TAG, useUnmergedTree = true)
                .performClick()

            composeTestRule.onNodeWithTag(title + SCREEN_TEST_TAG)
                .assertIsDisplayed()
        }
    }

    @Test
    fun test_nestedPreferenceHomeNavigation() {
        val settingsTitle = context.getString(Screen.SettingsScreen.title)

        composeTestRule.onNodeWithTag(
            testTag = settingsTitle + BOTTOM_TEST_TAG,
            useUnmergedTree = true
        )
            .performClick()

        composeTestRule.onNodeWithTag(settingsTitle + SCREEN_TEST_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun test_nestedHomeNavigation() {
        val homeTitle = context.getString(Screen.HomeScreen.title)

        composeTestRule.onNodeWithTag(testTag = homeTitle + BOTTOM_TEST_TAG, useUnmergedTree = true)
            .performClick()

        composeTestRule.onNodeWithTag(homeTitle + SCREEN_TEST_TAG)
            .assertIsDisplayed()


        val searchIconContentDescriptorString =
            context.getString(R.string.search_icon_content_descriptor)

        composeTestRule.onNodeWithContentDescription(
            searchIconContentDescriptorString,
            useUnmergedTree = true
        ).performClick()


        val contentString = context.getString(com.ebdz.search.R.string.search_content_description)

        composeTestRule.onNodeWithText(contentString, useUnmergedTree = true)
            .assertIsDisplayed()
    }
}

