plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
}

dependencies {
    api(Deps.android.ktx)
    api(libs.composeNavigation)
}
