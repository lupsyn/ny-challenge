plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KAPT)
    id(GradlePlugin.APOLLO)
}

apollo {
    packageName.set("com.ebdz.network")
    srcDir(file("src/main/graphql/"))

    customScalarsMapping.set(
        mapOf(
            "URI" to "okhttp3.HttpUrl",
            "HTML" to "android.text.Spanned"
        )
    )
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.data.repository)

    implementation(Deps.coroutines.core)

    implementation(Deps.koin.android)

    implementation(Deps.network.okHttp)
    implementation(Deps.network.okHttpLoggingInterceptors)
    implementation(Deps.network.apolloRuntime)
    implementation(Deps.network.apolloHttCcache)
    implementation(Deps.network.apolloNormalizedCache)

    androidTestImplementation(Deps.test.runner)
    androidTestImplementation(Deps.test.room)

    testImplementation(Deps.coroutines.test)
    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.mockk)
    testImplementation(Deps.test.mockito)
    testImplementation(Deps.test.mockitoInline)
}