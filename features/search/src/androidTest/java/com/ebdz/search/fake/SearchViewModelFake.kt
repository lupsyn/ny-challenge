package com.ebdz.search.fake

import com.ebdz.search.mapper.RepositoryMapper
import com.ebdz.search.presentation.GetListOfRepositoriesUseCaseFake
import com.ebdz.search.presentation.SearchViewModel

// TODO : refector injecting this directly via Koin.
class SearchViewModelFake : SearchViewModel(
    getListOfRepositoriesUseCase = GetListOfRepositoriesUseCaseFake(),
    repositoryMapper = RepositoryMapper()
) {
    fun isReturningContent() {
        (getListOfRepositoriesUseCase as GetListOfRepositoriesUseCaseFake).returnDefaultValues()
    }

    fun isReturningError() {
        (getListOfRepositoriesUseCase as GetListOfRepositoriesUseCaseFake).shouldReturnError()
    }

    fun isReturningNoContent() {
        (getListOfRepositoriesUseCase as GetListOfRepositoriesUseCaseFake).shouldReturnNoContent()
    }

    fun clean() {
        (getListOfRepositoriesUseCase as GetListOfRepositoriesUseCaseFake).clean()
    }
}
