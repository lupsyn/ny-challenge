plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.di")
}

dependencies {
    implementation(projects.domain)

    implementation(Deps.coroutines.core)

    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.mockito)
    testImplementation(Deps.test.mockitoInline)
}
