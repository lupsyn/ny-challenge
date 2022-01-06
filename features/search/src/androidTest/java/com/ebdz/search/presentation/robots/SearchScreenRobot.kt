package com.ebdz.search.presentation.robots

import androidx.activity.ComponentActivity
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ebdz.core.extension.openUrl
import com.ebdz.designsystem.Theme
import com.ebdz.search.fake.SearchViewModelFake
import com.ebdz.search.presentation.SearchScreen
import com.ebdz.search.utils.BaseAndroidComposeTest
import com.ebdz.search.utils.BaseRobotScreen
import org.junit.Before

internal fun BaseAndroidComposeTest.withSearchScreenRobot(
    func: SearchScreenRobot.() -> Unit
) {
    val searchViewModel = SearchViewModelFake()
    SearchScreenRobot(
        searchViewModel,
        composeTestRule
    ).apply(func)
}

internal class SearchScreenRobot(
    private val searchVIewModel: SearchViewModelFake,
    baseAndroidComposeTest: AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity>
) : BaseRobotScreen(
    baseAndroidComposeTest
) {
    @Before
    fun setup() {
        searchVIewModel.clean()
        composeTestRule.mainClock.autoAdvance = false
    }

    @OptIn(ExperimentalComposeUiApi::class)
    fun whenViewIsLoaded() =
        composeTestRule.setContent {
            Theme {
                SearchScreen(
                    searchViewModel = searchVIewModel,
                    modifier = Modifier.testTag(SCREEN_TEST_TAG),
                    onUpClicked = {},
                    onItemSelected = {}
                )
            }
        }

    fun returnContent() {
        searchVIewModel.isReturningContent()
    }

    fun givenRepositoryReturnError() {
        searchVIewModel.isReturningError()
    }

    fun thenContentScreenHasVisibility(displayed: Boolean = true) {
        if (displayed) {
            composeTestRule.onNodeWithTag(SCREEN_TEST_TAG)
                .assertIsDisplayed()
        } else {
            composeTestRule.onNodeWithContentDescription(label = SCREEN_TEST_TAG)
                .assertDoesNotExist()
        }
    }

    fun thenLoadingScreenHasVisibility(displayed: Boolean = true) {
        if (displayed) {
            composeTestRule.onNodeWithContentDescription(label = "Loading screen")
                .assertIsDisplayed()
        } else {
            composeTestRule.onNodeWithContentDescription(label = "Loading screen")
                .assertDoesNotExist()
        }
    }

    fun thenErrorScreenHasVisibility(displayed: Boolean = true) {
        if (displayed) {
            composeTestRule.onNodeWithContentDescription(label = "Error screen")
                .assertIsDisplayed()
        } else {
            composeTestRule.onNodeWithContentDescription(label = "Error screen")
                .assertDoesNotExist()
        }
    }

    companion object {
        const val SCREEN_TEST_TAG = "search_screen"
    }
}
