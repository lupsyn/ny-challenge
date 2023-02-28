package com.ebdz.buildsrc.tools

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.ManagedVirtualDevice

/**
 * Configuring UTP for app
 */
@Suppress("UnstableApiUsage")
fun CommonExtension<*, *, *, *>.addSingleDeviceTestOptions() {
    testOptions {
        emulatorSnapshots {
            enableForTestFailures = true
            maxSnapshotsForTestFailures = 2
        }

        ManagedVirtualDevice("pixel2").apply {
            device = "Pixel 2"
            apiLevel = 29
            systemImageSource = "google"
        }.also { devices.add(it) }
    }
}
