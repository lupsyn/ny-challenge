package com.ebdz.network.provider

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * A [Interceptor] that adds an auth token to requests.
 */
data class AuthInterceptor(
    val accessToken: String
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "$accessToken")
            .build()
        return chain.proceed(request)
    }
}
