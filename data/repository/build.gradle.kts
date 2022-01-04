plugins {
    id(GradlePlugin.KOTLIN_LIBRARY)
}

dependencies {
    implementation(projects.domain)
    implementation(Deps.koin.core)
    implementation(Deps.coroutines.core)

    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.mockito)
    testImplementation(Deps.test.mockitoInline)
}
