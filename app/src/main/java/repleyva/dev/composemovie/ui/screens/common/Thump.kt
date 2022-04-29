package repleyva.dev.composemovie.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import repleyva.dev.composemovie.R
import repleyva.dev.composemovie.model.MediaItem

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ItemThump(mediaItem: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
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
}
