package com.ebdz.domain.di

import com.ebdz.domain.usecase.GetListOfRepositoriesUseCase
import com.ebdz.domain.usecase.implementation.GetListOfRepositoriesUseCaseImpl
import org.koin.dsl.module

/**
 * Domain dependency injection module.
 */
val domainModule = module {
    factory<GetListOfRepositoriesUseCase> {
        GetListOfRepositoriesUseCaseImpl(get())
    }
}
