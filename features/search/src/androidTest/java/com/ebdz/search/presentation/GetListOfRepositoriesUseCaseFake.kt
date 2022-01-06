package com.ebdz.search.presentation

import com.ebdz.domain.model.Repository
import com.ebdz.domain.usecase.GetListOfRepositoriesUseCase

class GetListOfRepositoriesUseCaseFake : GetListOfRepositoriesUseCase {
    var repository: Repository? = null

    var throwError: Boolean = false
    val anError = Throwable("Generic error")

    fun returnDefaultValues() {
        repository = Repository(
            id = "Id",
            name = "name",
            openGraphImageUrl = "openGraphImageUrl",
            stargazerCount = 0,
            url = "url",
            shortDescriptionHTML = "shortDescriptionHTML"
        )
    }

    fun shouldReturnError() {
        throwError = true
    }

    fun clean() {
        repository = null
        throwError = false
    }

    override suspend fun invoke(orgName: String): List<Repository> {
        return when {
            throwError -> throw anError
            else -> listOf(repository!!)
        }
    }
}