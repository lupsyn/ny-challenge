package com.ebdz.buildsrc

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFrameworkLibrariesConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidFrameworkLibraries(extension)
        }
    }

    private fun Project.configureAndroidFrameworkLibraries(
        extension: LibraryExtension,
    ) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        extension.apply {

            buildFeatures {
                viewBinding = true
                dataBinding = true
            }

            dependencies {
                add("implementation", libs.findBundle("androidFramework").get())
            }
        }
    }
}
