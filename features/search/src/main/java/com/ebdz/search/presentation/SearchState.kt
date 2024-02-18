package com.ebdz.search.presentation

import com.ebdz.search.model.Repository

sealed class SearchState {
    data object InitialState : SearchState()
    data object Loading : SearchState()
    data object NoContent : SearchState()

    data class Error(val cause: Throwable) : SearchState()
    data class Loaded(val repositories: List<Repository>) : SearchState()
}
