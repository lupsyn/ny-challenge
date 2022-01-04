package com.ebdz.compose.presentation.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ebdz.compose.R
import com.ebdz.designsystem.components.DefaultFullscreenContent
import com.ebdz.designsystem.components.SearchToolbarWithTitleAndSearchIcon
import com.ebdz.designsystem.components.TitleWithString

/**
 * App Home screen.
 */
@Composable
fun HomeScreen(
    onShowSearchBar: () -> Unit,
    modifier: Modifier = Modifier,
    @StringRes screenTitle: Int
) {
    Column {
        SearchToolbarWithTitleAndSearchIcon(
            titleId = screenTitle,
            searchIconContentDescriptor = R.string.search_icon_content_descriptor,
            onShowSearchBar = onShowSearchBar
        )
        Column(modifier = modifier) {
            DefaultFullscreenContent(
                {},
                title = { TitleWithString(R.string.home_content_description) },
                modifier = Modifier
            )
        }
    }
}