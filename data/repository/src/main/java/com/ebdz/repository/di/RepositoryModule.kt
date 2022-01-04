package com.ebdz.repository.di

import com.ebdz.domain.repository.GitHubRepository
import com.ebdz.repository.GitHubRepositoryImpl
import com.ebdz.repository.mapper.GitHubMapper
import org.koin.dsl.module

/**
 * Repository dependency injection module.
 */
val repositoryModule = module {
    factory<GitHubRepository> { GitHubRepositoryImpl(get(), get()) }
    factory { GitHubMapper() }
}
