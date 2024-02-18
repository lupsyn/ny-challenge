package com.ebdz.compose.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.ebdz.compose.R
import com.ebdz.navigation.Destinations


sealed class Screen(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    data object HomeScreen : Screen(
        route = Destinations.Home,
        title = R.string.home,
        icon = Icons.Outlined.Home
    )

    data object SettingsScreen : Screen(
        route = Destinations.Settings,
        title = R.string.settings,
        icon = Icons.Outlined.Settings
    )

    data object AboutScreen : Screen(
        route = Destinations.About,
        title = R.string.about,
        icon = Icons.Outlined.Settings
    )

    data object SearchScreen : Screen(
        route = Destinations.Search,
        title = R.string.search,
        icon = Icons.Outlined.Search
    )
}
