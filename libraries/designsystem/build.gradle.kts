plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE)
}

dependencies {
    implementation(Deps.koin.android)

    implementation("io.coil-kt:coil:1.4.0")
    implementation(Deps.compose.coil)
    
    implementation(Deps.compose.viewModel)
}
