plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.librarycompose")
}

android {
    namespace = "com.ebdz.preference"
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.libraries.designsystem)

    testImplementation(projects.libraries.test)

    debugImplementation(libs.composeTestManifest)
    androidTestImplementation(libs.bundles.androidTest)
}
