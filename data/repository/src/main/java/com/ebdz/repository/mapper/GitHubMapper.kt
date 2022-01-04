package com.ebdz.repository.mapper

import com.ebdz.repository.model.Repository
import com.ebdz.domain.model.Repository as DomainRepository

class GitHubMapper {
    fun toDomain(repository: Repository): DomainRepository =
        with(repository) {
            DomainRepository(
                id = id,
                name = name,
                openGraphImageUrl = openGraphImageUrl,
                stargazerCount = stargazerCount,
                url = url,
                shortDescriptionHTML = shortDescriptionHTML
            )
        }
}
