package com.ebdz.compose.navigation

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ebdz.compose.model.Screen
import com.ebdz.compose.model.Screen.SettingsScreen
import com.ebdz.navigation.Destinations
import com.ebdz.navigation.PREF_GRAPH_ROUTE
import com.ebdz.navigation.SCREEN_TEST_TAG
import com.ebdz.preference.presentation.AboutScreen
import com.ebdz.preference.presentation.PreferenceScreen


fun NavGraphBuilder.prefGraph(navController: NavController) {
    navigation(
        startDestination = SettingsScreen.route,
        route = PREF_GRAPH_ROUTE
    ) {

        composable(SettingsScreen.route) {
            PreferenceScreen(
                screenTitle = SettingsScreen.title,
                modifier = Modifier.testTag(stringResource(SettingsScreen.title) + SCREEN_TEST_TAG),
                onAboutClick = { navController.navigate(Destinations.About) }
            )
        }

        composable(Screen.AboutScreen.route) {
            AboutScreen(
                onUpPress = { navController.navigateUp() },
                modifier = Modifier.testTag(stringResource(Screen.AboutScreen.title) + SCREEN_TEST_TAG)
            )
        }
    }
}