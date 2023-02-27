package com.ebdz.preference.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ebdz.core.extension.getVersionName
import com.ebdz.designsystem.components.ToolbarWithTitle
import com.ebdz.preference.R

@Composable
fun PreferenceScreen(
    modifier: Modifier = Modifier,
    @StringRes screenTitle: Int = -1,
    onAboutClick: () -> Unit
) {
    Column {
        ToolbarWithTitle(titleID = screenTitle)
        Column(modifier = modifier) {
            AboutItem(onAboutClick)
            VersionItem()
        }
    }
}

@Composable
private fun VersionItem() {
    val title = stringResource(id = R.string.preference_title_version)
    val version = LocalContext.current.getVersionName()

    PreferenceItem(title = title, version)
}

@Composable
private fun AboutItem(onAboutClick: () -> Unit) {
    PreferenceItem(
        title = stringResource(id = R.string.preference_title_about),
        onItemClick = onAboutClick
    )
}

@Composable
private fun PreferenceItem(
    title: String,
    description: String? = null,
    onItemClick: () -> Unit = { }
) {
    Column(
        modifier = Modifier
            .clickable { onItemClick() }
            .padding(start = 32.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(48.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1
        )
        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
