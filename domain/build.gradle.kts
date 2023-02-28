plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.di")
}

dependencies {
    implementation(Deps.logging)
    implementation(Deps.coroutines.core)

    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.mockk)
    testImplementation(Deps.coroutines.test)
}
