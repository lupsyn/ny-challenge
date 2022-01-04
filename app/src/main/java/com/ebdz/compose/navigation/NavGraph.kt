package com.ebdz.compose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ebdz.compose.model.Screen
import com.ebdz.compose.model.Screen.HomeScreen
import com.ebdz.compose.model.Screen.SettingsScreen
import com.ebdz.navigation.BOTTOM_TEST_TAG
import com.ebdz.navigation.Destinations
import com.ebdz.navigation.HOME_GRAPH_ROUTE
import com.ebdz.navigation.ROOT_GRAPH_ROUTE

/**
 * Navigation Graph to control the app navigation.
 *
 * @param startGraphRoute the start destination of the graph
 */
@Composable
fun NavGraph(
    items: List<Screen> = listOf(HomeScreen, SettingsScreen),
    startGraphRoute: String = HOME_GRAPH_ROUTE
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    BottomNavigationItem(
                        modifier = Modifier.testTag(stringResource(screen.title) + BOTTOM_TEST_TAG),
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.title)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding -> SetupNavGraph(navController, startGraphRoute, innerPadding) }
}

@Composable
private fun SetupNavGraph(
    navController: NavHostController,
    startGraphRoute: String,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = startGraphRoute,
        route = ROOT_GRAPH_ROUTE,
        modifier = Modifier.padding(innerPadding)
    ) {
        homeGraph(navController)
        prefGraph(navController)
    }
}
