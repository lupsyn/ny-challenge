plugins {
    id("com.ebdz.com.gradleplugin.androidapplication")
    id("com.ebdz.com.gradleplugin.detekt")
    id("com.ebdz.com.gradleplugin.di")
    id("com.ebdz.com.gradleplugin.applicationcompose")
}

dependencies {
    implementation(project(":domain"))

    implementation(project(":data:repository"))
    implementation(project(":data:network"))

    implementation(project(":features:preference"))
    implementation(project(":features:search"))

    implementation(project(":libraries:core"))
    implementation(project(":libraries:test"))
    implementation(project(":libraries:designsystem"))
    implementation(project(":libraries:navigation"))

    implementation(libs.bundles.androidFramework)
    implementation(libs.composeActivity)
//    implementation(libs.splashScreen)
    implementation("androidx.core:core-splashscreen:1.1.0-alpha01")
    debugImplementation(libs.composeTestManifest)
    implementation(Deps.koin.android)
}
