package com.compose.base.ui.screens

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.compose.base.ui.base.BaseDestination

sealed class MainDestination {
    object Home : BaseDestination("Home")
}