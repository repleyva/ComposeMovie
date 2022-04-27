package repleyva.dev.composemovie.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import repleyva.dev.composemovie.ui.theme.ComposeMovieTheme

@Composable
fun ComposeMovie(content: @Composable () -> Unit) =
    ComposeMovieTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }