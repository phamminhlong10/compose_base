package com.compose.base.ui.base

import androidx.compose.runtime.Composable

@Composable
fun BaseScreen(content: @Composable () -> Unit){
    content()
}