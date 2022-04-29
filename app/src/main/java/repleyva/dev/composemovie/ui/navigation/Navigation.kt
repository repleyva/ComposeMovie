package repleyva.dev.composemovie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import repleyva.dev.composemovie.ui.screens.detail.DetailScreen
import repleyva.dev.composemovie.ui.screens.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Main.route
    ) {
        composable(Routes.Main) {
            MainScreen { mediaItem ->
                navController.navigate(Routes.Detail.createNavRoute(mediaItem.id))
            }
        }
        composable(Routes.Detail) {
            DetailScreen(
                id = it.findArg(NavArg.MediaId),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    route: Routes,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = route.route,
        arguments = route.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}