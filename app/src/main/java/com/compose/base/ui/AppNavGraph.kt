package com.compose.base.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.base.ui.base.BaseDestination
import com.compose.base.ui.screens.mainNavGraph

@Composable
fun AppNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = AppDestination.RootNavGraph.destination,
        startDestination = AppDestination.MainNavGraph.destination){
            mainNavGraph(navController)
    }
}

fun NavGraphBuilder.composable(destination: BaseDestination, content: @Composable (NavBackStackEntry) -> Unit){
    composable(
        route = destination.destination,
        arguments = destination.arguments,
        content = content)
}

fun NavHostController.navigate(destination: BaseDestination){
    when(destination){
        is BaseDestination.Up ->{
            destination.results.forEach { (key, value) ->
                previousBackStackEntry?.savedStateHandle?.set(key, value)
            }
            navigateUp()
        }
        else -> navigate(route = destination.destination)
    }
}