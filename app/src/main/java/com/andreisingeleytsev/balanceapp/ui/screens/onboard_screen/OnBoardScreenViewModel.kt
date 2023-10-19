package com.andreisingeleytsev.balanceapp.ui.screens.onboard_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.playingquizapp.domain.onboard.usecases.OnBoardFinishUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardScreenViewModel @Inject constructor(
    private val onBoardFinishUseCase: OnBoardFinishUseCase
):ViewModel() {
    fun finishOnBoard(){
        viewModelScope.launch {
            onBoardFinishUseCase.invoke()
        }
    }
}