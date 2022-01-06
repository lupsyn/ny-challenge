package com.ebdz.search.presentation

import com.ebdz.search.presentation.robots.withSearchScreenRobot
import com.ebdz.search.utils.BaseAndroidComposeTest
import org.junit.Test

class SearchScreenTest : BaseAndroidComposeTest() {

    @Test
    fun test_loadingScreenIsDisplayed() {
        withSearchScreenRobot {
            composeTestRule.mainClock.autoAdvance = false
            composeTestRule.mainClock.advanceTimeByFrame()

            whenViewIsLoaded()

//            // TODO : not deterministic idling resources should be used here!
//            composeTestRule.mainClock.advanceTimeBy(200L)

            thenLoadingScreenHasVisibility()
        }
    }

    @Test
    fun test_shouldDisplayContent() {
        withSearchScreenRobot {
            returnContent()
            whenViewIsLoaded()
            thenContentScreenHasVisibility()
        }
    }

    @Test
    fun test_shouldDisplayError() {
        withSearchScreenRobot {
            givenRepositoryReturnError()

            whenViewIsLoaded()

            thenLoadingScreenHasVisibility(false)
            thenContentScreenHasVisibility(false)
            thenErrorScreenHasVisibility(true)
        }
    }
}
