package repleyva.dev.composemovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import repleyva.dev.composemovie.ui.ComposeMovie
import repleyva.dev.composemovie.ui.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMovie {
                MainScreen()
            }
        }
    }
}