package repleyva.dev.composemovie.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import repleyva.dev.composemovie.model.getMedia
import repleyva.dev.composemovie.ui.screens.common.ItemThump

@Composable
fun DetailScreen(id: Int) {
    val mediaItem = remember { getMedia().first { it.id == id } }
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = mediaItem.title) })
    }) {
        ItemThump(mediaItem, Modifier.padding(it))
    }
}