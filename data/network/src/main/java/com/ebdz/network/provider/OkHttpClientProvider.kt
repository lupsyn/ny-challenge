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
            .addInterceptor(interceptorProvider.provideAuthInterceptor("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"))
            .build()
}
