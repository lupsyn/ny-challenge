package com.ebdz.domain.usecase

import com.ebdz.domain.model.Repository

/**
 * Use case to retrieve list of repositories
 */
interface GetListOfRepositoriesUseCase {
    /**
     * Retrieve list of [Repository] from our data layer
     *
     * @param orgName organization name
     *
     */
    suspend operator fun invoke(orgName: String): List<Repository>
}
