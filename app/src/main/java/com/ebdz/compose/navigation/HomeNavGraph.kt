package com.ebdz.compose.navigation

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ebdz.compose.model.Screen.HomeScreen
import com.ebdz.compose.model.Screen.SearchScreen
import com.ebdz.compose.presentation.home.HomeScreen
import com.ebdz.core.extension.openUrl
import com.ebdz.navigation.Destinations
import com.ebdz.navigation.HOME_GRAPH_ROUTE
import com.ebdz.navigation.SCREEN_TEST_TAG
import com.ebdz.search.presentation.SearchScreen


@OptIn(ExperimentalComposeUiApi::class)
fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(
        startDestination = HomeScreen.route,
        route = HOME_GRAPH_ROUTE
    ) {


        composable(HomeScreen.route) {
            HomeScreen(
                onShowSearchBar = { navController.navigate(Destinations.Search) },
                screenTitle = HomeScreen.title,
                modifier = Modifier.testTag(stringResource(HomeScreen.title) + SCREEN_TEST_TAG)
            )
        }

        composable(SearchScreen.route) {
            val context = LocalContext.current

            SearchScreen(
                onItemSelected = { context.openUrl(url = it) },
                onUpClicked = { navController.navigateUp() },
                modifier = Modifier.testTag(stringResource(SearchScreen.title) + SCREEN_TEST_TAG)
            )
        }
    }
}
