package com.ebdz.search.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ebdz.designsystem.components.DefaultFullscreenContent
import com.ebdz.designsystem.components.ErrorFullScreen
import com.ebdz.designsystem.components.LoadingBar
import com.ebdz.designsystem.components.NoContentImage
import com.ebdz.designsystem.components.TitleWithString
import com.ebdz.designsystem.components.ToolbarWithSearchBar
import com.ebdz.search.R
import com.ebdz.search.model.Repository
import com.ebdz.search.presentation.SearchState.Error
import com.ebdz.search.presentation.SearchState.InitialState
import com.ebdz.search.presentation.SearchState.Loaded
import com.ebdz.search.presentation.SearchState.Loading
import org.koin.androidx.compose.getViewModel

@ExperimentalComposeUiApi
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onUpClicked: () -> Unit,
    onItemSelected: (String) -> Unit,
    searchViewModel: SearchViewModel = getViewModel()
) {
    val searchViewModelViewState by remember(searchViewModel) {
        searchViewModel.searchState
    }.collectAsState(initial = InitialState)

    val searchedText by remember(searchViewModel) {
        searchViewModel.searchTextFlow
    }.collectAsState(initial = "")

    Column {
        ToolbarWithSearchBar(
            placeholderText = stringResource(id = R.string.search_place_holder),
            onSearchTextChanged = { searchViewModel.onSearchTextChanged(it) },
            onClearClick = { searchViewModel.onClearClick() },
            onSearch = { searchViewModel.onLaunchSearch() },
            onNavigateBack = onUpClicked,
            searchText = searchedText,
        )
        Content(
            modifier = modifier,
            searchState = searchViewModelViewState,
            onRetry = { searchViewModel.onLaunchSearch() }
        ) { repository -> onItemSelected(repository.url) }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    searchState: SearchState,
    onRetry: () -> Unit,
    onRepositoryClick: (Repository) -> Unit,
) = Crossfade(
    targetState = searchState,
    label = ""
) { state ->
    when (state) {
        is Error -> ErrorFullScreen(
            errorString = R.string.error,
            modifier = modifier,
            onRetryClicked = onRetry
        )

        is Loaded -> Repositories(state.repositories) { onRepositoryClick(it) }

        Loading -> LoadingBar(modifier)
        InitialState -> DefaultFullscreenContent(
            {},
            title = { TitleWithString(R.string.search_content_description) },
            modifier = Modifier
        )

        SearchState.NoContent -> DefaultFullscreenContent(
            { NoContentImage(modifier = Modifier.size(256.dp)) },
            title = { TitleWithString(R.string.no_content_description) },
            modifier = Modifier
        )
    }
}
