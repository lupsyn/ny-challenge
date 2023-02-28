plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.librarycompose")
    id("com.ebdz.com.gradleplugin.di")
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.libraries.designsystem)
    implementation(projects.domain)

    implementation(Deps.android.playCore)
    implementation(Deps.koin.compose)

    testImplementation(projects.libraries.test)
}
