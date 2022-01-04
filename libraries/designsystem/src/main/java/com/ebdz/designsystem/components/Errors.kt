package com.ebdz.designsystem.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ebdz.designsystem.R

@Composable
fun ErrorFullScreen(
    modifier: Modifier = Modifier,
    @StringRes errorString: Int,
    onRetryClicked: () -> Unit
) {
    val errorContentDescriptor =
        stringResource(R.string.ErrorScreenIconButton)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = onRetryClicked,
                modifier = modifier
                    .semantics { contentDescription = errorContentDescriptor }
                    .size(250.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Error,
                    contentDescription = "Error button",
                    modifier = modifier.size(256.dp)
                )
            }
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(errorString),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSecondary,
            )
        }
    }
}
