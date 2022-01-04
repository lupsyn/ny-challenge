plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE)
    id(GradlePlugin.PARCELIZE)
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.libraries.designsystem)
    implementation(projects.domain)

    implementation(Deps.android.playCore)
    implementation(Deps.koin.android)
    implementation(Deps.koin.compose)

    testImplementation(projects.libraries.test)
}
