package com.ebdz.domain.repository

import com.ebdz.domain.model.Repository

interface GitHubRepository {
    suspend fun getListOfRepositoriesByOrganizationName(organizationName: String): List<Repository>
}
