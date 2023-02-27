repositories {
    google()
    mavenCentral()
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

object PluginsVersions {
    const val gradle = "7.1.0-beta05"
    const val kotlin = "1.5.30"
    const val detekt = "1.17.1"
    const val apollo = "3.0.0"

}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.kotlin}")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${PluginsVersions.detekt}")
    implementation("com.apollographql.apollo3:apollo-gradle-plugin:${PluginsVersions.apollo}")
}