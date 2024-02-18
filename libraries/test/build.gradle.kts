plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
}

android {
    namespace = "com.ebdz.test"
}


dependencies {
//    api(libs.androidAnnotation)
    api(libs.bundles.junit)
    api(libs.bundles.mockito)
    api(libs.assertjCore)
    api(libs.truth)
    api(libs.kotlinCoroutinesTest)
    api(libs.kotlinTurbine)
    api(libs.junitParamTest)
    api(libs.mockWebServer)
    api(libs.androidCoreTesting)
}
