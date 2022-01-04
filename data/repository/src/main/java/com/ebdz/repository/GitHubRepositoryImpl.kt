package com.ebdz.repository

import com.ebdz.domain.repository.GitHubRepository
import com.ebdz.repository.datasource.GitHubNetworkDataSource
import com.ebdz.repository.mapper.GitHubMapper
import com.ebdz.domain.model.Repository as RepositoryDomain

class GitHubRepositoryImpl(
    private val networkDataSource: GitHubNetworkDataSource,
    private val domainMapper: GitHubMapper
) : GitHubRepository {
    override suspend fun getListOfRepositoriesByOrganizationName(organizationName: String): List<RepositoryDomain> {
        return networkDataSource.getListOfRepositoriesByOrganizationName(organizationName)
            .map {
                domainMapper.toDomain(it)
            }
    }
}
