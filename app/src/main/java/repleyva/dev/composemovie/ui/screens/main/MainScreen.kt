package repleyva.dev.composemovie.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import repleyva.dev.composemovie.model.MediaItem
import repleyva.dev.composemovie.ui.ComposeMovie

@Composable
fun MainScreen(onMediaClick: (MediaItem) -> Unit) {
    ComposeMovie {
        Scaffold(
            topBar = { MainAppBar() }
        ) {
            MediaList(
                onMediaClick = onMediaClick,
                modifier = Modifier.padding(it)
            )
        }
    }
}