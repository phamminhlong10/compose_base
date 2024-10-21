package com.compose.base.ui

import com.compose.base.ui.base.BaseDestination

sealed class AppDestination {
    object RootNavGraph: BaseDestination("rootNavGraph")
    object MainNavGraph: BaseDestination("mainNavGraph")
}