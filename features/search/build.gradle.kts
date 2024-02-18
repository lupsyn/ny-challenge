plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.librarycompose")
    id("com.ebdz.com.gradleplugin.di")
}
android {
    namespace = "com.ebdz.search"
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.libraries.designsystem)
    implementation(projects.domain)
    implementation(libs.koinCompose)

    testImplementation(projects.libraries.test)

    debugImplementation(libs.composeTestManifest)
    androidTestImplementation(libs.bundles.androidTest)
}
