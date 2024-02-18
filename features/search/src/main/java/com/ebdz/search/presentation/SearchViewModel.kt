package com.ebdz.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebdz.domain.usecase.GetListOfRepositoriesUseCase
import com.ebdz.search.mapper.RepositoryMapper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * [SearchViewModel] contains main logic of the app.
 *
 * It's open due [SearchViewModelFake]
 */
open class SearchViewModel(
    val getListOfRepositoriesUseCase: GetListOfRepositoriesUseCase,
    private val repositoryMapper: RepositoryMapper
) : ViewModel() {

    private val searchMutableText: MutableStateFlow<String> = MutableStateFlow("")
    val searchTextFlow: StateFlow<String>
        get() = searchMutableText.asStateFlow()

    private val searchMutableState = MutableStateFlow<SearchState>(SearchState.InitialState)
    val searchState: StateFlow<SearchState>
        get() = searchMutableState.asStateFlow()

    private fun loadRepositoriesByOrgName(orgName: String) {
        searchMutableState.value = SearchState.Loading

        viewModelScope.launch(exceptionHandler) {
            getListOfRepositoriesUseCase.invoke(orgName = orgName)
                .map { repositoryMapper.toView(it) }
                .also { repositories ->
                    if (repositories.isEmpty()) {
                        searchMutableState.value = SearchState.NoContent
                    } else {

                        searchMutableState.value = SearchState.Loaded(repositories)
                    }
                }
        }
    }

    fun onLaunchSearch() = loadRepositoriesByOrgName(searchMutableText.value)

    fun onSearchTextChanged(texChanged: String) {
        searchMutableText.value = texChanged
        if (texChanged.isEmpty()) {
            searchMutableState.value = SearchState.InitialState
        }
    }

    fun onClearClick() {
        searchMutableText.value = ""
        searchMutableState.value = SearchState.InitialState
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        searchMutableState.value = SearchState.Error(exception)
    }
}
