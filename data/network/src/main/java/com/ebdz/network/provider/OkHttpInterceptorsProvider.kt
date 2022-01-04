package com.ebdz.network.provider

import okhttp3.logging.HttpLoggingInterceptor

class OkHttpInterceptorsProvider {
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    fun provideAuthInterceptor(accessToken: String) = AuthorizationInterceptor(accessToken)
}

