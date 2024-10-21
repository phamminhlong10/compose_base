package com.compose.base.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class BaseViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    protected val _navigator = MutableSharedFlow<BaseDestination>()
    val navigator = _navigator.asSharedFlow()
    protected fun showLoading() {
            _isLoading.value = true

    }
    protected fun hideLoading() {
            _isLoading.value = false
    }

    protected fun launch(context: CoroutineContext = EmptyCoroutineContext, job: suspend () -> Unit) =
        viewModelScope.launch(context) {
            job.invoke()
        }
}