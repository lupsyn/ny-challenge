package com.ebdz.search.presentation

import com.ebdz.search.model.Repository

sealed class SearchState {
    object InitialState : SearchState()
    object Loading : SearchState()
    data class Error(val cause: Throwable) : SearchState()
    data class Loaded(val repositories: List<Repository>) : SearchState()
    object NoContent : SearchState()
}
