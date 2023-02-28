plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.di")
}

dependencies {
    api(Deps.android.ktx)
    api(Deps.coroutines.core)

    api(libs.mulogging)
    implementation(Deps.koin.android)
}
