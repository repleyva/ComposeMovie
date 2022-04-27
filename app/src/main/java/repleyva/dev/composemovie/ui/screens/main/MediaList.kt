package repleyva.dev.composemovie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import repleyva.dev.composemovie.model.MediaItem
import repleyva.dev.composemovie.model.getMedia

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediaList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        cells = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
        modifier = modifier
    ) {
        items(getMedia()) {
            MediaViewItem(it, Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)))
        }
    }
}

@Composable
fun MediaViewItem(mediaItem: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.cell_thump_height))
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(
                    data = mediaItem.imageUrl,
                ),
                contentDescription = "Personas",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (mediaItem.type == MediaItem.Type.VIDEO) Icon(
                imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.play_icon_size)),
                tint = Color.White
            )
        }
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
}