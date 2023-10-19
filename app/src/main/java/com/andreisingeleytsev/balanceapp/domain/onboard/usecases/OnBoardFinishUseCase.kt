package com.andreisingeleytsev.playingquizapp.domain.onboard.usecases

import com.andreisingeleytsev.balanceapp.domain.onboard.OnboardStateRepository
import javax.inject.Inject

class OnBoardFinishUseCase @Inject constructor(
    private val repository: OnboardStateRepository
) {
    suspend operator fun invoke(){
        repository.onFinishedSave()
    }
}