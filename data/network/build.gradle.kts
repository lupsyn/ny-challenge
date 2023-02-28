plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.di")
    id("com.apollographql.apollo3")
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

    implementation(libs.bundles.okHttp)

    implementation(Deps.network.apolloRuntime)
    implementation(Deps.network.apolloHttCcache)
    implementation(Deps.network.apolloNormalizedCache)

    androidTestImplementation(libs.bundles.androidTest)

}
