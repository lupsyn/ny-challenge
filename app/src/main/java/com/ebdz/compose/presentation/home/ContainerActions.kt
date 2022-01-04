package com.ebdz.compose.presentation.home

import com.ebdz.compose.model.Screen

internal data class ContainerActions(
    val onAboutClick: () -> Unit = {},
    val setCurrentContentSection: (Screen) -> Unit = {}
)
