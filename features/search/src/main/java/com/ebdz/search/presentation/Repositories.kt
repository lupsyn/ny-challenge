package com.ebdz.search.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ebdz.designsystem.components.NetworkImageRoundedIcon
import com.ebdz.search.model.Repository


@Composable
fun Repositories(
    repositories: List<Repository>,
    onClick: (repository: Repository) -> Unit
) {
    LazyColumn {
        items(repositories) { repository ->
            RepositoryRow(repository) { onClick(repository) }
        }
    }
}

@Composable
private fun RepositoryRow(
    repository: Repository,
    onClick: (repository: Repository) -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onClick(repository) }
    ) {

        NetworkImageRoundedIcon(
            url = repository.openGraphImageUrl,
            modifier = Modifier
                .size(104.dp)
                .padding(16.dp)
        )

        Column(modifier = Modifier.padding(end = 16.dp)) {
            Text(repository.name)
            Text(repository.shortDescriptionHTML)
        }
    }
}
