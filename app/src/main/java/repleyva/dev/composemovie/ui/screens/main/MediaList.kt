package repleyva.dev.composemovie.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import repleyva.dev.composemovie.R
import repleyva.dev.composemovie.model.MediaItem
import repleyva.dev.composemovie.model.getMedia
import repleyva.dev.composemovie.ui.screens.common.ItemThump

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediaList(onMediaClick: (MediaItem) -> Unit, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        cells = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
        modifier = modifier
    ) {
        items(getMedia()) {
            MediaViewItem(
                mediaItem = it,
                onClick = { onMediaClick(it) },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall))
            )
        }
    }
}

@Composable
fun MediaViewItem(
    mediaItem: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        ItemThump(mediaItem)
        ItemTitle(mediaItem)
    }
}

@Composable
private fun ItemTitle(mediaItem: MediaItem) {
    Text(
        text = mediaItem.title,
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(
                dimensionResource(id = R.dimen.padding_medium)
            )
    )
}