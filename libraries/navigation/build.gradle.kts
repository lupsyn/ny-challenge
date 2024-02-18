plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
}

android {
    namespace = "com.ebdz.navigation"
}

dependencies {
//    api(libs.androidKtxCore)
    api(libs.composeNavigation)
}
