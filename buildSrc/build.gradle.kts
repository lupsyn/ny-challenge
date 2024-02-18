plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.ebdz.com.gradleplugin.androidapplication"
            implementationClass = "com.ebdz.buildsrc.AndroidApplicationConventionPlugin"
        }
        register("androidLibraryDI") {
            id = "com.ebdz.com.gradleplugin.di"
            implementationClass = "com.ebdz.buildsrc.AndroidDIConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "com.ebdz.com.gradleplugin.librarycompose"
            implementationClass = "com.ebdz.buildsrc.AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "com.ebdz.com.gradleplugin.applicationcompose"
            implementationClass = "com.ebdz.buildsrc.AndroidApplicationComposeConventionPlugin"
        }
        register("androidFrameworkLibraries") {
            id = "com.ebdz.com.gradleplugin.androidframework"
            implementationClass = "com.ebdz.buildsrc.AndroidFrameworkLibrariesConventionPlugin"
        }
//        register("androidLibraryDetekt") {
//            id = "com.ebdz.com.gradleplugin.detekt"
//            implementationClass = "com.ebdz.buildsrc.AndroidLibraryDetektConventionPlugin"
//        }
        register("androidKotlin") {
            id = "com.ebdz.com.gradleplugin.androidkotlin"
            implementationClass = "com.ebdz.buildsrc.AndroidLibraryKotlinConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.ebdz.com.gradleplugin.androidlibrary"
            implementationClass = "com.ebdz.buildsrc.AndroidLibraryConventionPlugin"
        }
        register("androidTest") {
            id = "com.ebdz.com.gradleplugin.androidtest"
            implementationClass = "com.ebdz.buildsrc.AndroidTestConventionPlugin"
        }
    }
}

dependencies {
    with(baseLibs) {
        implementation(kotlinGradlePlugin)
        implementation(gradlePlugin)
        implementation(detektPlugin)
        implementation(apolloPlugin)
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
    kotlinOptions {
        allWarningsAsErrors = false
//        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xopt-in=kotlin.Experimental")
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}
