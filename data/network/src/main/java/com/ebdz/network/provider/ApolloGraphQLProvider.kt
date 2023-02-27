package com.ebdz.network.provider

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.network.okHttpClient
import com.ebdz.network.type.HTML
import com.ebdz.network.type.URI
import com.ebdz.network.utils.HttpUrlApolloAdapter
import com.ebdz.network.utils.SpannedStringApolloAdapter
import okhttp3.OkHttpClient

class ApolloGraphQLProvider(
    private val okHttpClient: OkHttpClient,
    private val normalizedCacheFactory: NormalizedCacheFactory
) {
    fun getApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .addCustomScalarAdapter(URI.type, HttpUrlApolloAdapter)
            .addCustomScalarAdapter(HTML.type, SpannedStringApolloAdapter)
            .okHttpClient(okHttpClient)
            .normalizedCache(normalizedCacheFactory = normalizedCacheFactory)
            .build()
    }
}

const val BASE_URL = "https://api.github.com/graphql"
