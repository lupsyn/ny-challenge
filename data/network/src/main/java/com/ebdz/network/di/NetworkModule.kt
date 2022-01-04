package com.ebdz.network.di

import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory
import com.ebdz.network.datasource.GitHubNetworkDataSourceImpl
import com.ebdz.network.mapper.RepositoryMapper
import com.ebdz.network.provider.ApolloCacheProvider
import com.ebdz.network.provider.ApolloGraphQLProvider
import com.ebdz.network.provider.OkHttpCacheProvider
import com.ebdz.network.provider.OkHttpClientProvider
import com.ebdz.network.provider.OkHttpInterceptorsProvider
import com.ebdz.repository.datasource.GitHubNetworkDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Network dependency injection module.
 */
val networkModule = module {
    single<GitHubNetworkDataSource> { GitHubNetworkDataSourceImpl(get(), get()) }
    single { OkHttpClientProvider().getOkHttpClient(get(), get()) }
    single { OkHttpCacheProvider().provideCache(androidApplication()) }
    single { ApolloGraphQLProvider(get(), get()).getApolloClient() }

    factory<NormalizedCacheFactory> { ApolloCacheProvider().getNormalizedCacheFactory() }
    factory { OkHttpInterceptorsProvider() }
    factory { RepositoryMapper() }
}

