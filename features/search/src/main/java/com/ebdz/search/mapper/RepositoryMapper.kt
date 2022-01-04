package com.ebdz.search.mapper

import com.ebdz.domain.model.Repository
import com.ebdz.search.model.Repository as ViewRepository

class RepositoryMapper {
    fun toView(repository: Repository): ViewRepository =
        with(repository) {
            ViewRepository(
                id = id,
                name = name,
                openGraphImageUrl = openGraphImageUrl,
                stargazerCount = stargazerCount,
                url = url,
                shortDescriptionHTML = shortDescriptionHTML
            )
        }
}
