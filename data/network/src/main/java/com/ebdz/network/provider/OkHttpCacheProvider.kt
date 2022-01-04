package com.ebdz.network.provider

import android.app.Application
import java.io.File
import okhttp3.Cache

class OkHttpCacheProvider {
    fun provideCache(application: Application) = Cache(
        directory = File(application.cacheDir, "http_cache"),
        maxSize = MAX_SIZE
    )

    companion object {
        const val MAX_SIZE = 50L * 1024L * 1024L // 50 MiB
    }
}
