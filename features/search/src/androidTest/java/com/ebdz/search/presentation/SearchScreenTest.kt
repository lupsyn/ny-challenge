package com.ebdz.search.presentation

import com.ebdz.search.presentation.robots.withSearchScreenRobot
import com.ebdz.search.utils.BaseAndroidComposeTest
import org.junit.Test

class SearchScreenTest : BaseAndroidComposeTest() {
    @Test
    fun test_shouldDisplayContent() {
        withSearchScreenRobot {
            givenRepositoryReturnContent()

            whenViewIsLoaded()

            thenContentDescriptionIsDisplayed()

            makeSearchWithValue("A search")

            thenContentIsDisplayed()
            thenNoContentIsDisplayed(false)
            thenErrorScreenHasVisibility(false)
        }
    }

    @Test
    fun test_shouldDisplayError() {
        withSearchScreenRobot {
            givenRepositoryReturnError()

            whenViewIsLoaded()

            makeSearchWithValue("A search")

            thenContentIsDisplayed(false)
            thenNoContentIsDisplayed(false)
            thenErrorScreenHasVisibility()
        }
    }

    @Test
    fun test_shouldDisplayNoContent() {
        withSearchScreenRobot {
            givenRepositoryIsReturningNoContent()

            whenViewIsLoaded()

            makeSearchWithValue("A search")

            thenContentIsDisplayed(false)
            thenErrorScreenHasVisibility(false)
            thenNoContentIsDisplayed()
        }
    }
}
