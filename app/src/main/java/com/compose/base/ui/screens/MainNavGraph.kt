package com.compose.base.ui.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.compose.base.ui.AppDestination
import com.compose.base.ui.composable

fun NavGraphBuilder.mainNavGraph(navController: NavHostController){
    navigation(route = AppDestination.MainNavGraph.destination, startDestination = MainDestination.Home.destination){
        composable(MainDestination.Home){backStackEntry ->
            Greeting(name = "")
        }
    }
}