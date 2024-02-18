import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("io.gitlab.arturbosch.detekt")
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

tasks.register("clean") {
    delete(rootProject.buildDir)
}

tasks.withType(KotlinCompile::class.java).configureEach {
    kotlinOptions {
        allWarningsAsErrors = false
//        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xopt-in=kotlin.Experimental")
        jvmTarget = "1.8"
    }
}
