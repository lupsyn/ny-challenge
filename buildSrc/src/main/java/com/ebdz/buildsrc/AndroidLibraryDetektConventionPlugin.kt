package com.ebdz.buildsrc

import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryDetektConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            val extension = extensions.getByType<DetektExtension>()
            configureDetekt(extension)
        }
    }

    private fun Project.configureDetekt(
        extension: DetektExtension
    ) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        extension.apply {

            dependencies {
                add("detektPlugins", libs.findBundle("detekt").get())
            }
        }
    }

}
