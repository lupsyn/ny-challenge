package com.ebdz.buildsrc.tools

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

object Utils {

    fun CommonExtension<*, *, *, *, *>.excludeFromPackagingOptions(vararg toExclude: String) {
        packaging {
            toExclude.forEach { resources.excludes.add(it) }
        }
    }

    fun quote(input: String): String = "\"" + input + "\""

    fun isNonStableVersion(version: String): Boolean {
        val stableKeyword =
            listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }

    /**
     * Get the version code from command line param.
     * @return int If the param -PversionCode is present then return int value,
     * else 1
     */
    fun Project.getVersionCode(): Int =
        if (project.hasProperty("versionCode"))
            project.property("versionCode").toString().toInt()
        else 1
}
