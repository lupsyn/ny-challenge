package com.ebdz.network.provider

import okhttp3.Cache
import okhttp3.OkHttpClient

class OkHttpClientProvider {
    fun provideOkHttpClient(
        interceptorProvider: OkHttpInterceptorsProvider,
        cache: Cache
    ): OkHttpClient =
        OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(interceptorProvider.provideLoggingInterceptor())
            .addInterceptor(interceptorProvider.provideAuthInterceptor(githubToken))
            .build()

    companion object {
        // FIXME : Token should be store in local.properties, for the sake of this challenge i'll leave it here.
        const val githubToken = "" // <- this should be added to the local properties
    }
}


