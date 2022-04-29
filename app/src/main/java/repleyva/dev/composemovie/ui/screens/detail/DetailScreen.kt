package repleyva.dev.composemovie.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import repleyva.dev.composemovie.model.getMedia
import repleyva.dev.composemovie.ui.screens.common.ItemThump
import repleyva.dev.composemovie.ui.screens.shared.ArrowBackIcon

@Composable
fun DetailScreen(id: Int, onUpClick: () -> Unit) {
    val mediaItem = remember { getMedia().first { it.id == id } }
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = mediaItem.title) },
            navigationIcon = { ArrowBackIcon(onUpClick) }
        )
    }) {
        ItemThump(mediaItem, Modifier.padding(it))
    }
}