package com.ebdz.repository.datasource

import com.ebdz.repository.model.Repository

/**
 * Repositories network data source contract.
 */
interface GitHubNetworkDataSource {

    suspend fun getListOfRepositoriesByOrganizationName(organizationName: String): List<Repository>
}
