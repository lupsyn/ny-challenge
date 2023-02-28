plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.librarycompose")
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.libraries.designsystem)

    testImplementation(projects.libraries.test)

    androidTestImplementation(projects.libraries.test)
}
