package com.ebdz.domain.usecase.implementation

import com.ebdz.domain.model.Repository
import com.ebdz.domain.repository.GitHubRepository
import com.ebdz.domain.usecase.GetListOfRepositoriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetListOfRepositoriesUseCaseImpl(private val repository: GitHubRepository) :
    GetListOfRepositoriesUseCase {
    override suspend fun invoke(organizationName: String): List<Repository> =
        withContext(Dispatchers.IO) {
            repository.getListOfRepositoriesByOrganizationName(organizationName)
        }
}
