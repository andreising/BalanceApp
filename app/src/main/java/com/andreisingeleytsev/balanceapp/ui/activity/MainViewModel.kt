package com.andreisingeleytsev.balanceapp.ui.activity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.balanceapp.ui.utils.Routes
import com.andreisingeleytsev.playingquizapp.domain.onboard.usecases.OnBoardGetStateUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val onBoardGetStateUseCase: OnBoardGetStateUseCase
): ViewModel() {
    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String?> = mutableStateOf(null)
    val startDestination: State<String?> = _startDestination

    init {
        viewModelScope.launch {
            onBoardGetStateUseCase.invoke().collect{completed ->
                if (completed) {
                    _startDestination.value = Routes.HOME_SCREEN
                } else {
                    _startDestination.value = Routes.ONBOARDING_SCREEN
                }
                _isLoading.value = false
            }
        }
    }
}