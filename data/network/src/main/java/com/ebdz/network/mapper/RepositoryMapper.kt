package com.ebdz.network.mapper

import com.ebdz.network.GetStarredRepositoriesFromOrganizationNameQuery
import com.ebdz.repository.model.Repository

class RepositoryMapper {
    fun toRepository(networkRepositoryModel: GetStarredRepositoriesFromOrganizationNameQuery.OnRepository): Repository {
        return Repository(
            id = networkRepositoryModel.id,
            name = networkRepositoryModel.name,
            openGraphImageUrl = networkRepositoryModel.openGraphImageUrl.toString(),
            stargazerCount = networkRepositoryModel.stargazerCount,
            url = networkRepositoryModel.url.toString(),
            shortDescriptionHTML = networkRepositoryModel.shortDescriptionHTML.toString()
        )
    }
}
