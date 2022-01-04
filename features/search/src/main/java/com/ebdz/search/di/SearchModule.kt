package com.ebdz.search.di

import com.ebdz.search.mapper.RepositoryMapper
import com.ebdz.search.presentation.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    viewModel { SearchViewModel(get(), get()) }
    factory { RepositoryMapper() }
}
