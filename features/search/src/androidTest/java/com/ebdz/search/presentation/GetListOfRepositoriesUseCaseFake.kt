package com.ebdz.search.presentation

import com.ebdz.domain.model.Repository
import com.ebdz.domain.usecase.GetListOfRepositoriesUseCase

class GetListOfRepositoriesUseCaseFake : GetListOfRepositoriesUseCase {
    var repositories: List<Repository>? = null

    var throwError: Boolean = false
    val anError = Throwable("Generic error")

    fun returnDefaultValues() {
        repositories =
            listOf(
                Repository(
                    id = "Id",
                    name = "name",
                    openGraphImageUrl = "openGraphImageUrl",
                    stargazerCount = 0,
                    url = "url",
                    shortDescriptionHTML = "shortDescriptionHTML"
                )
            )
    }

    fun shouldReturnError() {
        throwError = true
    }

    fun shouldReturnNoContent() {
        repositories = emptyList()
    }

    fun clean() {
        repositories = null
        throwError = false
    }

    override suspend fun invoke(orgName: String): List<Repository> {
        return when {
            throwError -> throw anError
            else -> repositories!!
        }
    }
}
