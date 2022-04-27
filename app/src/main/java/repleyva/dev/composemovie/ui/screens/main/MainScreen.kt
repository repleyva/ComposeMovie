package repleyva.dev.composemovie.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import repleyva.dev.composemovie.MainAppBar
import repleyva.dev.composemovie.MediaList

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { MainAppBar() }
    ) {
        MediaList(Modifier.padding(it))
    }
}