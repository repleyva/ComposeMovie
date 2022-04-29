package repleyva.dev.composemovie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import repleyva.dev.composemovie.ui.screens.detail.DetailScreen
import repleyva.dev.composemovie.ui.screens.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Main.route
    ) {
        composable(Routes.Main.route) {
            MainScreen { mediaItem ->
                navController.navigate(Routes.Detail.createNavRoute(mediaItem.id))
            }
        }
        composable(
            route = Routes.Detail.route,
            arguments = Routes.Detail.args
        ) {
            val id = it.arguments?.getInt(NavArg.MediaId.key)
            requireNotNull(id)
            DetailScreen(id)
        }
    }
}