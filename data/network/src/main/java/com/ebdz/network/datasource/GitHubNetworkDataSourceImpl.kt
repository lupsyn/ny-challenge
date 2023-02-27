package com.ebdz.network.datasource

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.exception.ApolloException
import com.ebdz.network.GetStarredRepositoriesFromOrganizationNameQuery
import com.ebdz.network.mapper.RepositoryMapper
import com.ebdz.repository.datasource.GitHubNetworkDataSource
import com.ebdz.repository.model.Repository

class GitHubNetworkDataSourceImpl(
    private val apolloClient: ApolloClient,
    private val repositoryMapper: RepositoryMapper
) : GitHubNetworkDataSource {

    override suspend fun getListOfRepositoriesByOrganizationName(organizationName: String): List<Repository> {
        val getStarredFromOrganization =
            GetStarredRepositoriesFromOrganizationNameQuery("org:$organizationName sort:stars-desc")
        // TODO : cache policy here should be set somewhere else.(external file ? or passed down by use-case ?)

        val response = apolloClient.query(getStarredFromOrganization)
            .fetchPolicy(FetchPolicy.CacheFirst)
            .execute()

        try {
            return response.data?.search?.edges?.map {
                it?.node?.onRepository?.let { networkRepository ->
                    repositoryMapper.toRepository(
                        networkRepository
                    )
                } ?: error("$DEFAULT_ERROR_MESSAGE : repository node is null")
            } ?: error("$DEFAULT_ERROR_MESSAGE : response.data is null")
        } catch (apollo: ApolloException) {
            error("$DEFAULT_ERROR_MESSAGE : " + apollo.message.orEmpty())
        }
    }

    companion object {
        const val DEFAULT_ERROR_MESSAGE = "Error fetching repositories"
    }
}
