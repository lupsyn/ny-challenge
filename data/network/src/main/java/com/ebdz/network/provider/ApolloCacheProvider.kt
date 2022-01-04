package com.ebdz.network.provider

import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory

class ApolloCacheProvider {
    fun getNormalizedCacheFactory(
        maxSizeBytes: Int = MAX_CACHE_DIMEN,
        expireAfterMillis: Long = EXPIRING_TIME,
    ): MemoryCacheFactory =
        MemoryCacheFactory(
            maxSizeBytes = maxSizeBytes,
            expireAfterMillis = expireAfterMillis
        )

    companion object {
        const val MAX_CACHE_DIMEN = 10 * 1024 * 1024
        const val EXPIRING_TIME = 3000L
    }
}
