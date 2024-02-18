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

android {
    namespace = "com.ebdz.network"
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.data.repository)

    implementation(libs.bundles.okHttp)
    implementation(libs.bundles.apolloBundle)

    androidTestImplementation(libs.bundles.androidTest)

}
