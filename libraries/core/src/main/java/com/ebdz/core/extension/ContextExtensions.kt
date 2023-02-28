@file:JvmName("extension-context")

package com.ebdz.core.extension

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.core.net.toUri
import mu.KotlinLogging.logger

private const val INVALID_VERSION = "x.x.x"


/**
 * Opens the given url in string format.
 *
 * @param url the url in string format
 */
fun Context.openUrl(url: String) {
    with(Intent(Intent.ACTION_VIEW)) {
        this.data = url.toUri()
        startActivity(this)
    }
}

/**
 * Returns the version name of the application.
 *
 * @return the version name of the application.
 */
fun Context.getVersionName(): String {
    var packageInfo: PackageInfo? = null
    packageName.let {
        try {
            packageInfo = packageManager.getPackageInfo(it, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            logger.error(e.localizedMessage)
        }
    }
    return packageInfo?.versionName ?: INVALID_VERSION
}

private val logger = logger {}
