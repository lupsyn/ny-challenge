package com.ebdz.search.presentation.robots

import androidx.activity.ComponentActivity
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ebdz.designsystem.Theme
import com.ebdz.search.R
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

    lateinit var searchContentDescription: String
    lateinit var noContentDescription: String

    @Before
    fun setup() {
        searchVIewModel.clean()
        composeTestRule.mainClock.autoAdvance = false
    }

    @OptIn(ExperimentalComposeUiApi::class)
    fun whenViewIsLoaded() =
        composeTestRule.setContent {
            Theme {
                searchContentDescription = stringResource(id = R.string.search_content_description)
                noContentDescription = stringResource(id = R.string.no_content_description)
                SearchScreen(
                    searchViewModel = searchVIewModel,
                    modifier = Modifier.testTag(SCREEN_TEST_TAG),
                    onUpClicked = {},
                    onItemSelected = {}
                )
            }
        }

    fun makeSearchWithValue(searchTxt: String) {
        searchVIewModel.onSearchTextChanged(searchTxt)
        searchVIewModel.onLaunchSearch()
    }

    fun givenRepositoryReturnContent() = searchVIewModel.isReturningContent()

    fun givenRepositoryReturnError() = searchVIewModel.isReturningError()

    fun givenRepositoryIsReturningNoContent() = searchVIewModel.isReturningNoContent()

    fun thenContentIsDisplayed(displayed: Boolean = true) {
        if (displayed) {
            composeTestRule.onNodeWithText("name")
                .assertIsDisplayed()
            composeTestRule.onNodeWithText("shortDescriptionHTML")
                .assertIsDisplayed()
        } else {
            composeTestRule.onNodeWithText("name")
                .assertDoesNotExist()
            composeTestRule.onNodeWithText("shortDescriptionHTML")
                .assertDoesNotExist()
        }
    }

    fun thenContentDescriptionIsDisplayed(displayed: Boolean = true) {
        if (displayed) {
            composeTestRule.onNodeWithText(searchContentDescription)
                .assertIsDisplayed()
        } else {
            composeTestRule.onNodeWithText(searchContentDescription)
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

    fun thenNoContentIsDisplayed(displayed: Boolean = true) {
        if (displayed) {
            composeTestRule.onNodeWithText(noContentDescription)
                .assertIsDisplayed()
        } else {
            composeTestRule.onNodeWithText(noContentDescription)
                .assertDoesNotExist()
        }
    }

    companion object {
        const val SCREEN_TEST_TAG = "search_screen"
    }
}
