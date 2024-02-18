plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.di")
}

android {
    namespace = "com.ebdz.core"
}

dependencies {
    api("androidx.core:core-ktx:1.12.0")
    api(libs.kotlinCoroutines)

    api(libs.mulogging)
    implementation(libs.koin)
}
