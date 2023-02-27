package com.ebdz.designsystem.components

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.ebdz.designsystem.R

/**
 * [ImageIconWithContentDescriptor] icon with content descriptor
 */
@Composable
fun ImageIconWithContentDescriptor(
    icon: ImageVector,
    @StringRes iconContentDescription: Int,
    iconColor: Color,
) {
    Icon(
        imageVector = icon,
        contentDescription = stringResource(id = iconContentDescription),
        modifier = Modifier.size(64.dp),
        tint = iconColor
    )
}

@Composable
fun NetworkImageRoundedIcon(url: String, modifier: Modifier) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                transformations(CircleCropTransformation())
                crossfade(true)
            }
        ),
        contentDescription = url,
        modifier = modifier
    )
}

@Composable
fun NoContentImage(modifier: Modifier) {
    Image(
        painter = rememberImagePainter(
            data = R.drawable.no_content,
            builder = {
                transformations(CircleCropTransformation())
                crossfade(true)
            }
        ),
        contentDescription = null,
        modifier = modifier
    )
}
