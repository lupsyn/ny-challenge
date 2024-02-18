plugins {
    id("com.ebdz.com.gradleplugin.androidlibrary")
    id("com.ebdz.com.gradleplugin.androidkotlin")
    id("com.ebdz.com.gradleplugin.di")
}
android {
    namespace = "com.ebdz.repository"
}

dependencies {
    implementation(projects.domain)
    implementation(libs.kotlinCoroutines)

    testImplementation(project(":libraries:test"))
}
